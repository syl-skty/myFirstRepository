package URL类的使用;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class UrlUtil {

	public static void getWebSource(String u) throws IOException {
		URL url = new URL(u);
		System.out.println("主机名：" + url.getHost() + "\n" + "端口号："
				+ url.getPort());
		InputStream in = url.openStream();// 获取url对应返回访问的网站资源,调用openStream()方法
		InputStreamReader inr = new InputStreamReader(in, "utf-8");// 将字节流对象转换为字符流对象
		BufferedReader br = new BufferedReader(inr);// 再转换为带缓冲的字符流对象，方便调用readLine()方法
		PrintWriter pw = new PrintWriter("D:\\文件操作测试文件夹\\网上读取的网页\\web1.html",
				"utf-8");
		String buffer;
		while ((buffer = br.readLine()) != null) {
			System.out.println(buffer);
			pw.println(buffer);
			pw.flush();
		}
		System.out.println("网页保存目录为：" + "D:\\文件操作测试文件夹\\网上读取的网页\\web1.html");
		in.close();
		inr.close();
		br.close();
		pw.close();
	}
}
