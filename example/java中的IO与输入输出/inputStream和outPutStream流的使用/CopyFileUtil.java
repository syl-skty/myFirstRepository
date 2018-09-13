package inputStream和outPutStream流的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import 有显示进度的完成文件传输工具.IOShowPercent;

/**
 * 使用输入输出流的三个实现类分别实现文件拷贝
 * 
 * @author 史永龙
 * 
 */
public class CopyFileUtil {
	public static Scanner input = new Scanner(System.in);

	public static void copyFile() throws IOException {
		System.out.print("请输入要拷贝的文件路径：");
		String copyFilePath = input.next();
		System.out.print("请输入要拷贝到的文件目录");
		String pasteDirectoryPath = input.next();
		File copyFile = new File(copyFilePath);
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("你要拷贝的文件不存在或不是文件！");
		}
		File pasteDirectory = new File(pasteDirectoryPath);
		if (!pasteDirectory.isDirectory()) {
			throw new IllegalArgumentException("请输入正确的要拷贝到的文件夹的路径！");
		}
		File pasteFile = new File(pasteDirectoryPath + "\\"
				+ copyFile.getName());
		FileInputStream fis = new FileInputStream(copyFile);
		FileOutputStream fos = new FileOutputStream(pasteFile);
		/*
		 * byte[] buf = new byte[1024 * 100]; int length = 0; try { long start =
		 * System.currentTimeMillis(); while ((length = fis.read(buf, 0,
		 * buf.length)) != -1) //
		 * 这里不使用read(buf),因为这个方法是把读到的字节填充到字节数组中，当读到最后时：读到的字节数量小于数组长度时会自动补充空的字节过去
		 * { fos.write(buf, 0, length); //
		 * 这里也不使用write(buf)方法，这样也会把最后读到的不够的字节自动填充，导致复制出的文件比原文件大 //
		 * 在RandomAccessFile()对象的read(byte[] //
		 * buf)方法会把buf中的内容填到数组中，但不会自动填充不够的元素 fos.flush();// 刷新缓冲区 } long end =
		 * System.currentTimeMillis(); System.out.println("文件拷贝完毕,总共用时：" + ((end
		 * - start) / 1000) + "毫秒"); fis.close(); fos.close(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		long timeUse = IOShowPercent.ShowPercent(fis, fos, (1024 * 20));
		System.out.println("文件传输完成，用时：" + timeUse + "毫秒");
	}
}
