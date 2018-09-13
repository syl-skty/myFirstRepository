package servlet完成文件上传;

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
 * 负责文件上传的工具类
 * 
 * @author skty
 *
 */
public class FileUploadUtil {

	/**
	 * 该方法实现了浏览器上传文件的实现
	 * 
	 * @param request
	 *            浏览器请求头
	 * @param outPath
	 *            文件保存路径
	 * @param sizeLimit
	 *            上传文件设置的是否存放在内存还是磁盘的临界值
	 * @param bufferSize
	 *            输出文件的缓冲字节数组的大小
	 * @param message
	 *            在下载完成后要输出的文字
	 * @return 正常下载时true,否则为false
	 */
	public static boolean uploadFile(HttpServletRequest request, String outPath, int sizeLimit, int bufferSize,
			String message) {
		FileOutputStream out = null;
		InputStream in = null;

		// 创建一个apache文件上传的文件的DiskFileItemFactory，用于初始化文件上传的参数设置
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置文件上传时是否保存在缓存中还是磁盘中的临界值，当高于临界值时放在磁盘中
		factory.setSizeThreshold(sizeLimit);

		// 设置临时存放的文件目录，"java.io.tmpdir"表示jvm默认的磁盘缓存目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// 创建文件上传的传输对象，并传入配置对象
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		// 设置文件传输对象识别接收信息头的编码
		fileUpload.setHeaderEncoding("utf-8");

		// 调用apache中的静态方法来判断当前请求时传输的内容是不是文件类型
		if (!ServletFileUpload.isMultipartContent(request)) {
			return false;
		}
		try {
			// 将当前请求中的内容提取出里面的文件部分，并将文件部分提取出来，封装在FileItem中，
			// 由于一个提交过来的请求有可能有多个文件，所以返回一个list<FileItem>
			List<FileItem> fileItems = fileUpload.parseRequest(request);

			// 对每一个文件项目进行遍历
			// 使用迭代器的方式迭代，提升效率
			Iterator<FileItem> iterator = fileItems.iterator();
			for (; iterator.hasNext();) {
				FileItem item = iterator.next();

				// 判断当前文件项目是不是只是普通表单字段，如果是，就不对其进行i/o操作
				if (item.isFormField()) {
					continue;
				} else {
					// 获取输入流，获取每个文件项目的输入流
					in = item.getInputStream();

					// 获取上传的文件的文件名
					String fileName = item.getName();

					// 开启输出流,输出到指定的文件
					out = new FileOutputStream(outPath + File.separator + fileName);

					// 创建字节缓冲数组
					byte[] buffer = new byte[bufferSize];

					int readNUm = 0;

					// 读取并输出
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
