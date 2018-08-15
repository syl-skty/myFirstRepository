package com.string.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

import com.web.utils.GetWebSource;

public class StringUtil {
	/**
	 * 获取页面对应的编码格式
	 * 
	 * @param url
	 *            URL对象
	 * @return 对应的编码格式
	 * @throws IOException
	 */
	public static String getWebCharset(URL url) {
		String charset = "utf-8";
		if (url == null) {
			return charset;
		}
		try {
			URLConnection connection = url.openConnection();
			if (connection.getContentEncoding() != null) {
				charset = connection.getContentEncoding();
				return charset;
			}
			InputStream in = GetWebSource.getInputStreamFromWeb(url);
			if (in != null) {
				String[] charsets = new String[] { "utf-8", "UTF-8", "gbk",
						"GBK", "iso-8859-1", "ISO-8859-1", "gb2312", "GB2312",
						"UTF-16", "utf-16", "ascii", "ASCII" };
				BufferedReader bfr = new BufferedReader(new InputStreamReader(
						in));
				String buffer = "";
				while ((buffer = bfr.readLine()) != null) {
					for (int i = 0; i < charsets.length; i++) {
						if (buffer.indexOf(charsets[i]) == -1) {
							continue;
						} else {
							charset = charsets[i];
							bfr.close();
							return charset;
						}
					}
				}
				bfr.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return charset;
		}
		return charset;
	}

	/**
	 * 从html文件中查找所有<img>标签
	 * 
	 * @param pageHtml
	 *            html文本串
	 * @return 所有url的集合
	 */
	public static Set<String> getPictureUrls(String pageHtml, String weburl) {
		Set<String> pictureUrls = new HashSet<String>();
		if (("".equals(pageHtml)) || pageHtml == null) {
			return null;
		}
		int imgindex = 0;
		weburl = weburl.substring(0, weburl.indexOf("com") + 3);
		while ((imgindex = pageHtml.indexOf("<img", imgindex)) != -1) {
			imgindex += 1;
			int lastindex = pageHtml.indexOf("/>", imgindex);
			if (lastindex != -1) {
				String theString = pageHtml.substring(imgindex + 1, lastindex);
				theString = theString.replaceAll("'", "\"");
				int srcindex = theString.indexOf("src");
				int first = theString.indexOf("\"", srcindex);
				int second = theString.indexOf("\"", first + 1);
				String url = theString.substring(first + 1, second).trim();
				if (url.indexOf("$") != -1) {
					continue;
				}
				if (url.indexOf("/") == 0) {
					url = weburl + url;
				}

				pictureUrls.add(url);
			}
		}
		return pictureUrls;
	}

	/**
	 * 从html文件中查找所有<a>标签
	 * 
	 * @param pageHtml
	 *            html文本串
	 * @param weburl
	 *            网站网址
	 * @return 所有url的集合
	 */
	public static Set<String> getWebUrls(String pageHtml, String weburl) {
		Set<String> webUrls = new HashSet<String>();
		if (("".equals(pageHtml)) || pageHtml == null) {
			return null;
		}
		String weburl1 = weburl.substring(0, weburl.indexOf("com") + 3);
		int webindex = 0;
		while ((webindex = pageHtml.indexOf("<a", webindex)) != -1) {
			webindex += 1;
			int endIndex = pageHtml.indexOf(">", webindex);
			if (endIndex != -1) {
				String theString = pageHtml.substring(webindex, endIndex);
				theString = theString.replaceAll("'", "\"");
				int hrefindex = theString.indexOf("href");
				if (hrefindex == -1) {
					continue;
				}
				int first = theString.indexOf("\"", hrefindex + 1);
				int second = theString.indexOf("\"", first + 1);
				if (second != -1) {
					String url = theString.substring(first + 1, second).trim();
					if (url.indexOf("javascript:") != -1) {
						continue;
					} else if (url.indexOf("http") == 0) {
						webUrls.add(url);
						continue;
					} else if (url.indexOf("www.") == 0) {
						webUrls.add(url);
						continue;
					} else if (url.indexOf("/") == 0) {
						url = weburl1 + url;
						webUrls.add(url);
						continue;
					} else if (weburl.indexOf("movielist") != -1) {
						int movieIndex = weburl.indexOf("movielist");
						int lastIndex = weburl.indexOf("/", movieIndex);
						String u = weburl.substring(0, lastIndex + 1);
						url = u + url;
						webUrls.add(url);
						continue;
					}
				}
			}
		}
		webindex = 0;
		while ((webindex = pageHtml.indexOf("<A", webindex)) != -1) {
			webindex += 1;
			int endIndex = pageHtml.indexOf(">", webindex);
			if (endIndex != -1) {
				String theString = pageHtml.substring(webindex, endIndex);
				theString = theString.replaceAll("'", "\"");
				int hrefindex = theString.indexOf("href");
				if (hrefindex == -1) {
					continue;
				}
				int first = theString.indexOf("\"", hrefindex + 1);
				int second = theString.indexOf("\"", first + 1);
				if (second != -1) {
					String url = theString.substring(first + 1, second).trim();
					if (url.indexOf("javascript:") != -1) {
						continue;
					} else if (url.indexOf("http") == 0) {
						webUrls.add(url);
						continue;
					} else if (url.indexOf("www.") == 0) {
						webUrls.add(url);
						continue;
					} else if (url.indexOf("/") == 0) {
						url = weburl1 + url;
						webUrls.add(url);
						continue;
					} else if (weburl.indexOf("movielist") != -1) {
						int movieIndex = weburl.indexOf("movielist");
						int lastIndex = weburl.indexOf("/", movieIndex);
						String u = weburl.substring(0, lastIndex + 1);
						url = u + url;
						webUrls.add(url);
						continue;
					}
				}
			}
		}
		return webUrls;
	}
}
