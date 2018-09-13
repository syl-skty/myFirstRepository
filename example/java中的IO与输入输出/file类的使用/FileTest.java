package file类的使用;

import java.io.File;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("输入你要遍历的文件夹的绝对路径：");
		Scanner input = new Scanner(System.in);
		String filePath = input.next();
		File file = new File(filePath);
		FileUtil.listFiles(file);
		input.close();
		// FileUtil.Mkdir("E:\\hello", "文件");
	}

}
