package ������֤��;

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
		// FileReader("java��һЩʹ�õļ���\\������֤��\\codes.txt"));
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

		String out = "D:\\�ļ����������ļ���\\3.jpg";
		try {
			ImageIO.write(VerifyCode_Util.getVerifyImg(str, new Font("����", Font.BOLD, 50), 100, 230), "jpg",
					new File(out));
			System.out.println("���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
