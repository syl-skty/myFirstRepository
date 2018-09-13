package 使用servlet实现文件断点下载;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支持文件断点下载的工具类
 * 
 * @author skty
 *
 */
public class FileDownloadUtil {

	/**
	 * 工具类实现浏览器断点下载支持
	 * 
	 * @param request
	 *            用户下载的请求头
	 * @param response
	 *            服务器回复头
	 * @param downloadFilePath
	 *            要下载的文件的全路径
	 * @param fileName
	 *            文件名
	 * @param bufferSize
	 *            输出流的使用的缓冲字节数组的大小
	 */
	public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFilePath,
			String fileName, int bufferSize) {
		RandomAccessFile raf = null;
		OutputStream out = null;

		// 获取请求头中的range字段的值，这个字段表示了浏览器上一次下载到的字节的个数,
		// 如：Range: bytes=206-5513 ,表示已经完成1024个字节，还有其他后面字节未完成
		// range字段的值如下： bytes=206-
		// 所以要从该字符中提取出已经下载的字节数
		String range = request.getHeader("Range");

		// 设置一个文件读取的游标的表示，当文件读取时就从该位置开始读
		long pos = 0;

		// 如果不为空则提取出已经下载的字节数 例 bytes=206-或bytes=206-5679
		if (range != null) {
			try {
				if (range.charAt(range.length() - 1) == '-') {
					// 将文件读取的开始游标设置为读取到的range中的值（获取浏览器已经下载完成的字节数）
					pos = Long.parseLong(range.replaceAll("bytes=", "").replace("-", ""));

					// 将response的状态值设置为206（即HttpServletResponse.SC_PARTIAL_CONTENT）
					// 表示发送的内容为部分内容（开启断点续传）
					response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
				} else {
					// 否则文件已经下载完成，无需再次下载
					return;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// 如果在提取字节时出现异常，将游标设置为0,重新下载文件
				pos = 0;
			}
		}

		File file = new File(downloadFilePath);

		// 获取文件大小（字节数）
		long fileSize = file.length();

		// 设置回复头，已让浏览器知道当前下载的信息
		response.setCharacterEncoding("utf-8");

		// 设置响应头的内容格式，这里 application/octet-stream表示二进制字节格式
		response.setHeader("Content-Type", "application/octet-stream");

		// 设置响应头响应的数据的单位，这里由于是发送文件，所以设置为byte
		response.setHeader("Accept-Ranges", "bytes");

		// 在响应头中设置其内容的长度为文件的长度，也就是文件的字节数
		response.setHeader("Content-Length", String.valueOf(fileSize));

		// 对文件名针对不同的浏览器进行文件名编码
		try {
			fileName = FileNameEncoder.getEncodeFileName(request.getHeader("User-Agent"), fileName);
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}

		// 设置回复头，将Content-Disposition设置为指定内容，并将我们指定的文件名设置在其中
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

		// 设置响应头中的Content-Range字段，例Content-Range: bytes 1001-2000/5000
		// 第一个数表示开始的字节，2000表示结束的字节，5000表示总字节数
		StringBuilder contentRange = new StringBuilder().append("bytes ").append(pos).append("-").append(fileSize - 1)
				.append("/").append(fileSize);

		response.setHeader("Content-Range", contentRange.toString());

		try {
			// 开启输出流
			out = response.getOutputStream();

			// 使用随机读写流，方便控制读写指针
			raf = new RandomAccessFile(file, "r");

			// 设置开始读的指针位置
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
			// 由于在浏览器每次暂停时都会取消数据传输，会导致tomcat 抛出i/o异常，所以我们这里不进行处理异常
			// e.printStackTrace();
		}

	}
}
