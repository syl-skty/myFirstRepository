package 字符流的基本操作;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TxtUtil.copyTxtByBR(new File("D:\\文件操作测试文件夹\\test.txt"), new File(
					"D:\\文件操作测试文件夹\\copyFile\\test.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
