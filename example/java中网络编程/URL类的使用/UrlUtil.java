package URL���ʹ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class UrlUtil {

	public static void getWebSource(String u) throws IOException {
		URL url = new URL(u);
		System.out.println("��������" + url.getHost() + "\n" + "�˿ںţ�"
				+ url.getPort());
		InputStream in = url.openStream();// ��ȡurl��Ӧ���ط��ʵ���վ��Դ,����openStream()����
		InputStreamReader inr = new InputStreamReader(in, "utf-8");// ���ֽ�������ת��Ϊ�ַ�������
		BufferedReader br = new BufferedReader(inr);// ��ת��Ϊ��������ַ������󣬷������readLine()����
		PrintWriter pw = new PrintWriter("D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\web1.html",
				"utf-8");
		String buffer;
		while ((buffer = br.readLine()) != null) {
			System.out.println(buffer);
			pw.println(buffer);
			pw.flush();
		}
		System.out.println("��ҳ����Ŀ¼Ϊ��" + "D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\web1.html");
		in.close();
		inr.close();
		br.close();
		pw.close();
	}
}
