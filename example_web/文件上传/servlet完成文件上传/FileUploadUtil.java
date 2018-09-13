package servlet����ļ��ϴ�;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �����ļ��ϴ��Ĺ�����
 * 
 * @author skty
 *
 */
public class FileUploadUtil {

	/**
	 * �÷���ʵ����������ϴ��ļ���ʵ��
	 * 
	 * @param request
	 *            ���������ͷ
	 * @param outPath
	 *            �ļ�����·��
	 * @param sizeLimit
	 *            �ϴ��ļ����õ��Ƿ������ڴ滹�Ǵ��̵��ٽ�ֵ
	 * @param bufferSize
	 *            ����ļ��Ļ����ֽ�����Ĵ�С
	 * @param message
	 *            ��������ɺ�Ҫ���������
	 * @return ��������ʱtrue,����Ϊfalse
	 */
	public static boolean uploadFile(HttpServletRequest request, String outPath, int sizeLimit, int bufferSize,
			String message) {
		FileOutputStream out = null;
		InputStream in = null;

		// ����һ��apache�ļ��ϴ����ļ���DiskFileItemFactory�����ڳ�ʼ���ļ��ϴ��Ĳ�������
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// �����ļ��ϴ�ʱ�Ƿ񱣴��ڻ����л��Ǵ����е��ٽ�ֵ���������ٽ�ֵʱ���ڴ�����
		factory.setSizeThreshold(sizeLimit);

		// ������ʱ��ŵ��ļ�Ŀ¼��"java.io.tmpdir"��ʾjvmĬ�ϵĴ��̻���Ŀ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// �����ļ��ϴ��Ĵ�����󣬲��������ö���
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		// �����ļ��������ʶ�������Ϣͷ�ı���
		fileUpload.setHeaderEncoding("utf-8");

		// ����apache�еľ�̬�������жϵ�ǰ����ʱ����������ǲ����ļ�����
		if (!ServletFileUpload.isMultipartContent(request)) {
			return false;
		}
		try {
			// ����ǰ�����е�������ȡ��������ļ����֣������ļ�������ȡ��������װ��FileItem�У�
			// ����һ���ύ�����������п����ж���ļ������Է���һ��list<FileItem>
			List<FileItem> fileItems = fileUpload.parseRequest(request);

			// ��ÿһ���ļ���Ŀ���б���
			// ʹ�õ������ķ�ʽ����������Ч��
			Iterator<FileItem> iterator = fileItems.iterator();
			for (; iterator.hasNext();) {
				FileItem item = iterator.next();

				// �жϵ�ǰ�ļ���Ŀ�ǲ���ֻ����ͨ���ֶΣ�����ǣ��Ͳ��������i/o����
				if (item.isFormField()) {
					continue;
				} else {
					// ��ȡ����������ȡÿ���ļ���Ŀ��������
					in = item.getInputStream();

					// ��ȡ�ϴ����ļ����ļ���
					String fileName = item.getName();

					// ���������,�����ָ�����ļ�
					out = new FileOutputStream(outPath + File.separator + fileName);

					// �����ֽڻ�������
					byte[] buffer = new byte[bufferSize];

					int readNUm = 0;

					// ��ȡ�����
					while ((readNUm = in.read(buffer, 0, bufferSize)) != -1) {
						out.write(buffer, 0, readNUm);
						out.flush();
					}
					in.close();
					out.close();
					if (message != null)
						System.out.println(message);

				}

			}
			return true;
		} catch (FileUploadException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
