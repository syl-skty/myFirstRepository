package file���ʹ��;

import java.io.File;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("������Ҫ�������ļ��еľ���·����");
		Scanner input = new Scanner(System.in);
		String filePath = input.next();
		File file = new File(filePath);
		FileUtil.listFiles(file);
		input.close();
		// FileUtil.Mkdir("E:\\hello", "�ļ�");
	}

}
