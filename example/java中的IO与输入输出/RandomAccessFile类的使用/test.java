package RandomAccessFile���ʹ��;

import java.io.File;
import java.io.FileNotFoundException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			copyByRAF.copyFile(
					new File("D:\\�ļ����������ļ���\\LOL_V4.0.7.6_FULL.exe"), new File(
							"D:\\�ļ����������ļ���\\copyFile\\test1.exe"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
