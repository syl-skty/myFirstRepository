package ʹ��servletʵ���ļ��ϵ�����;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ֧���ļ��ϵ����صĹ�����
 * 
 * @author skty
 *
 */
public class FileDownloadUtil {

	/**
	 * ������ʵ��������ϵ�����֧��
	 * 
	 * @param request
	 *            �û����ص�����ͷ
	 * @param response
	 *            �������ظ�ͷ
	 * @param downloadFilePath
	 *            Ҫ���ص��ļ���ȫ·��
	 * @param fileName
	 *            �ļ���
	 * @param bufferSize
	 *            �������ʹ�õĻ����ֽ�����Ĵ�С
	 */
	public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFilePath,
			String fileName, int bufferSize) {
		RandomAccessFile raf = null;
		OutputStream out = null;

		// ��ȡ����ͷ�е�range�ֶε�ֵ������ֶα�ʾ���������һ�����ص����ֽڵĸ���,
		// �磺Range: bytes=206-5513 ,��ʾ�Ѿ����1024���ֽڣ��������������ֽ�δ���
		// range�ֶε�ֵ���£� bytes=206-
		// ����Ҫ�Ӹ��ַ�����ȡ���Ѿ����ص��ֽ���
		String range = request.getHeader("Range");

		// ����һ���ļ���ȡ���α�ı�ʾ�����ļ���ȡʱ�ʹӸ�λ�ÿ�ʼ��
		long pos = 0;

		// �����Ϊ������ȡ���Ѿ����ص��ֽ��� �� bytes=206-��bytes=206-5679
		if (range != null) {
			try {
				if (range.charAt(range.length() - 1) == '-') {
					// ���ļ���ȡ�Ŀ�ʼ�α�����Ϊ��ȡ����range�е�ֵ����ȡ������Ѿ�������ɵ��ֽ�����
					pos = Long.parseLong(range.replaceAll("bytes=", "").replace("-", ""));

					// ��response��״ֵ̬����Ϊ206����HttpServletResponse.SC_PARTIAL_CONTENT��
					// ��ʾ���͵�����Ϊ�������ݣ������ϵ�������
					response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
				} else {
					// �����ļ��Ѿ�������ɣ������ٴ�����
					return;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// �������ȡ�ֽ�ʱ�����쳣�����α�����Ϊ0,���������ļ�
				pos = 0;
			}
		}

		File file = new File(downloadFilePath);

		// ��ȡ�ļ���С���ֽ�����
		long fileSize = file.length();

		// ���ûظ�ͷ�����������֪����ǰ���ص���Ϣ
		response.setCharacterEncoding("utf-8");

		// ������Ӧͷ�����ݸ�ʽ������ application/octet-stream��ʾ�������ֽڸ�ʽ
		response.setHeader("Content-Type", "application/octet-stream");

		// ������Ӧͷ��Ӧ�����ݵĵ�λ�����������Ƿ����ļ�����������Ϊbyte
		response.setHeader("Accept-Ranges", "bytes");

		// ����Ӧͷ�����������ݵĳ���Ϊ�ļ��ĳ��ȣ�Ҳ�����ļ����ֽ���
		response.setHeader("Content-Length", String.valueOf(fileSize));

		// ���ļ�����Բ�ͬ������������ļ�������
		try {
			fileName = FileNameEncoder.getEncodeFileName(request.getHeader("User-Agent"), fileName);
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}

		// ���ûظ�ͷ����Content-Disposition����Ϊָ�����ݣ���������ָ�����ļ�������������
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

		// ������Ӧͷ�е�Content-Range�ֶΣ���Content-Range: bytes 1001-2000/5000
		// ��һ������ʾ��ʼ���ֽڣ�2000��ʾ�������ֽڣ�5000��ʾ���ֽ���
		StringBuilder contentRange = new StringBuilder().append("bytes ").append(pos).append("-").append(fileSize - 1)
				.append("/").append(fileSize);

		response.setHeader("Content-Range", contentRange.toString());

		try {
			// ���������
			out = response.getOutputStream();

			// ʹ�������д����������ƶ�дָ��
			raf = new RandomAccessFile(file, "r");

			// ���ÿ�ʼ����ָ��λ��
			raf.seek(pos);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		byte[] buffer = new byte[bufferSize];
		int readNum = 0;
		try {
			while ((readNum = raf.read(buffer, 0, bufferSize)) != -1) {
				out.write(buffer, 0, readNum);
			}
			out.flush();
			out.close();
			raf.close();
		} catch (IOException e) {
			// �����������ÿ����ͣʱ����ȡ�����ݴ��䣬�ᵼ��tomcat �׳�i/o�쳣�������������ﲻ���д����쳣
			// e.printStackTrace();
		}

	}
}
