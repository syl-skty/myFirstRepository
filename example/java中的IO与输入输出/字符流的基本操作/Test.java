package �ַ����Ļ�������;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TxtUtil.copyTxtByBR(new File("D:\\�ļ����������ļ���\\test.txt"), new File(
					"D:\\�ļ����������ļ���\\copyFile\\test.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
