package RandomAccessFile类的使用;

import java.io.File;
import java.io.FileNotFoundException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			copyByRAF.copyFile(
					new File("D:\\文件操作测试文件夹\\LOL_V4.0.7.6_FULL.exe"), new File(
							"D:\\文件操作测试文件夹\\copyFile\\test1.exe"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
