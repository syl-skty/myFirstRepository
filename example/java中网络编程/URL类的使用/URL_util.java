package URL���ʹ��;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

public class URL_util {
	private static BufferedReader bfr;
	private static PrintWriter pw;

	public static void getWebPage(String url) throws Exception {

		URL u = new URL(url);
		URLConnection urlConnection = u.openConnection();
		urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		urlConnection.setDoInput(true);
		urlConnection.connect();
		InputStream in = urlConnection.getInputStream();
		System.out.println("�ļ�����" + urlConnection.getContentLength());
		String c = StringUtil.getWebCharset(u);
		bfr = new BufferedReader(new InputStreamReader(in, c));
		pw = new PrintWriter("D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\2.html", "utf-8");
		String pageHtml = "";
		String buffer = "";
		System.out.println(
				"================================================���ڶ�ȡ��ҳ=========================================");
		while ((buffer = bfr.readLine()) != null) {

			// String bu = new String(buffer.getBytes(), "utf-8");
			System.out.println(buffer);
			pageHtml = pageHtml + buffer;
			pw.println(buffer);
			pw.flush();
		}
		System.out.println(
				"===============================================��ҳ��ȡ����===========================================");
		System.out.println(u.getFile());
		System.out.println(c);
		Set<String> urls = StringUtil.getPictureOnWebpage(pageHtml);
		getPicture(urls);
		System.out.println("=====================ͼƬ�������=========================");
		System.out.println("==========================��ҳͼƬ============================");
		for (String string : urls) {
			System.out.println(string);
		}
		bfr.close();
		in.close();
		pw.close();
	}

	public static void getPicture(Set<String> urls) throws IOException {
		for (String string : urls) {
			String path = "D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\" + string.substring(string.lastIndexOf("/") + 1);
			getPage(string, path);
		}
	}

	public static void getPage(String url, String path) throws IOException {
		URL u = new URL(url);
		URLConnection urlConnection = u.openConnection();
		urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0;WindowsNT 5.0)");
		urlConnection.setDoInput(true);
		urlConnection.connect();
		InputStream in = urlConnection.getInputStream();
		FileOutputStream out = new FileOutputStream(path);
		byte[] buffer = new byte[1024 * 5];
		int num = 0;
		while ((num = in.read(buffer, 0, 1024 * 5)) != -1) {
			out.write(buffer, 0, num);
			out.flush();
		}
		out.close();
		in.close();
		System.out.println("��ȡ���");
	}

	public static void main(String[] args) {
		try {
			getPage("http://localhost:8080/ajax-test/", "D:\\�ļ����������ļ���\\test.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
