package URL类的使用;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class StringUtil {
	/**
	 * 获取页面对应的编码格式
	 * 
	 * @param url
	 *            URL对象
	 * @return 对应的编码格式
	 * @throws IOException
	 */
	public static String getWebCharset(URL url) throws IOException {
		String charset = null;
		URLConnection urlConnection = url.openConnection();
		urlConnection.addRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		urlConnection.setDoInput(true);
		urlConnection.connect();
		InputStream in = urlConnection.getInputStream();
		String[] charsets = new String[] { "utf-8", "UTF-8", "gbk", "GBK",
				"iso-8859-1", "ISO-8859-1", "gb2312", "GB2312", "UTF-16",
				"utf-16", "ascii", "ASCII" };
		BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
		String buffer = "";
		while ((buffer = bfr.readLine()) != null) {
			for (int i = 0; i < charsets.length; i++) {
				if (buffer.indexOf(charsets[i]) != -1) {
					charset = charsets[i];
					break;
				}
			}
		}
		bfr.close();
		return charset;
	}

	public static Set<String> getPictureOnWebpage(String pageHtml) {
		Set<String> pictureUrls = new HashSet<String>();
		int imgindex = 0;

		while ((imgindex = pageHtml.indexOf("<img", imgindex)) != -1) {
			imgindex += 1;
			int lastindex = pageHtml.indexOf(">", imgindex);
			String theString = pageHtml.substring(imgindex + 1, lastindex);
			int srcindex = theString.indexOf("src");
			int first = theString.indexOf("\"", srcindex);
			int second = theString.indexOf("\"", first + 1);
			String url = theString.substring(first + 1, second);
			pictureUrls.add(url);
		}
		return pictureUrls;
	}
}
