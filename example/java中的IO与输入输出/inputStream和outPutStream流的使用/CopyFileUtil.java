package inputStream��outPutStream����ʹ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import ����ʾ���ȵ�����ļ����乤��.IOShowPercent;

/**
 * ʹ�����������������ʵ����ֱ�ʵ���ļ�����
 * 
 * @author ʷ����
 * 
 */
public class CopyFileUtil {
	public static Scanner input = new Scanner(System.in);

	public static void copyFile() throws IOException {
		System.out.print("������Ҫ�������ļ�·����");
		String copyFilePath = input.next();
		System.out.print("������Ҫ���������ļ�Ŀ¼");
		String pasteDirectoryPath = input.next();
		File copyFile = new File(copyFilePath);
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("��Ҫ�������ļ������ڻ����ļ���");
		}
		File pasteDirectory = new File(pasteDirectoryPath);
		if (!pasteDirectory.isDirectory()) {
			throw new IllegalArgumentException("��������ȷ��Ҫ���������ļ��е�·����");
		}
		File pasteFile = new File(pasteDirectoryPath + "\\"
				+ copyFile.getName());
		FileInputStream fis = new FileInputStream(copyFile);
		FileOutputStream fos = new FileOutputStream(pasteFile);
		/*
		 * byte[] buf = new byte[1024 * 100]; int length = 0; try { long start =
		 * System.currentTimeMillis(); while ((length = fis.read(buf, 0,
		 * buf.length)) != -1) //
		 * ���ﲻʹ��read(buf),��Ϊ��������ǰѶ������ֽ���䵽�ֽ������У����������ʱ���������ֽ�����С�����鳤��ʱ���Զ�����յ��ֽڹ�ȥ
		 * { fos.write(buf, 0, length); //
		 * ����Ҳ��ʹ��write(buf)����������Ҳ����������Ĳ������ֽ��Զ���䣬���¸��Ƴ����ļ���ԭ�ļ��� //
		 * ��RandomAccessFile()�����read(byte[] //
		 * buf)�������buf�е�����������У��������Զ���䲻����Ԫ�� fos.flush();// ˢ�»����� } long end =
		 * System.currentTimeMillis(); System.out.println("�ļ��������,�ܹ���ʱ��" + ((end
		 * - start) / 1000) + "����"); fis.close(); fos.close(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		long timeUse = IOShowPercent.ShowPercent(fis, fos, (1024 * 20));
		System.out.println("�ļ�������ɣ���ʱ��" + timeUse + "����");
	}
}
