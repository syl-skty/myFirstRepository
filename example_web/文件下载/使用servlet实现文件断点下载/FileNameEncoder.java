package 使用servlet实现文件断点下载;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 使用这个类实现对浏览器下载文件时，针对的文件名中文乱码问题
 * 
 * 对不同的浏览器生成不同的文件名中文编码方式
 * 
 * @author skty
 *
 */
public class FileNameEncoder {

	/**
	 * 使用此方法来将一个下载的文件名对其中文字符进行编码，已防止浏览器会出现文件名乱码
	 * 
	 * @param agentMessage
	 *            浏览器头字段，里面包含了浏览器的版本信息
	 * @param fileName
	 *            要进行中文编码的文件名
	 * @return 编码后的文件名
	 * @throws UnsupportedEncodingException
	 */
	public static String getEncodeFileName(String agentMessage, String fileName) throws UnsupportedEncodingException {
		// IE浏览器(我使用的)，高版本的IE浏览器直接使用URLEncoder类加密就可以
		// Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko

		// 微软Edge浏览器
		// Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML,
		// like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299

		// 火狐浏览器
		// Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101
		// Firefox/59.0

		// QQ浏览器
		// Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.4952.400
		// QQBrowser/10.0.866.400
		if (agentMessage.contains("MSIE"))// 如果下载的浏览器是IE浏览器（低版本）
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			fileName = fileName.replace("+", " ");
			return fileName;

		} else if (agentMessage.contains("Chrome"))// 谷歌浏览器
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			return fileName;
		} else // 其他浏览器（包括高版本的IE浏览器）
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			StringBuilder builder = new StringBuilder().append("\"").append(fileName).append("\"");
			return builder.toString();
		}
	}
}
