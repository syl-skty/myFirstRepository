package 生成验证码;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		// BufferedReader reader = new BufferedReader(new
		// FileReader("java中一些使用的技术\\生成验证码\\codes.txt"));
		// String buffer = "";
		// while ((buffer = reader.readLine()) != null) {
		// list.add(new String(buffer.getBytes("gbk"), "utf-8"));
		// }
		// reader.close();
		char[] cs = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		for (char c : cs) {
			list.add(String.valueOf(c));
			list.add(String.valueOf(Character.toUpperCase(c)));
		}
		String str = "";
		for (int i = 0; i < 4; i++) {
			int index = new Random().nextInt(list.size());
			str = str + list.get(index);
		}

		String out = "D:\\文件操作测试文件夹\\3.jpg";
		try {
			ImageIO.write(VerifyCode_Util.getVerifyImg(str, new Font("宋体", Font.BOLD, 50), 100, 230), "jpg",
					new File(out));
			System.out.println("完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
