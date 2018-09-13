package RandomAccessFile类的使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class copyByRAF {
	/**
	 * 使用RandomAccessFile的方式拷贝文件(手动设置缓冲区)
	 * 
	 * @param copyFile
	 *            要被拷贝的文件
	 * @param paste
	 *            拷贝到的文件
	 * @throws FileNotFoundException
	 */
	public static void copyFile(File copyFile, File pasteFile)
			throws FileNotFoundException {
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("你要拷贝的文件不存在或不是文件！");
		}
		if (!pasteFile.exists()) {
			try {
				pasteFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RandomAccessFile raf1 = new RandomAccessFile(copyFile, "r");
		RandomAccessFile raf2 = new RandomAccessFile(pasteFile, "rw");
		byte[] buf = new byte[1024 * 100];// 手动设置的缓冲区大小应当适中
		try {
			long start = System.currentTimeMillis();
			while (raf1.read(buf) != -1) {
				raf2.write(buf);
			}
			long end = System.currentTimeMillis();
			System.out.println("文件拷贝完毕,总共用时：" + (end - start) + "毫秒");
			raf1.close();
			raf2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 按照一个字节一个字节的方式复制文件
	 * 
	 * @param copyFile
	 * @param pasteFile
	 */
	public static void copyFileByByte(File copyFile, File pasteFile)
			throws FileNotFoundException {
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("你要拷贝的文件不存在或不是文件！");
		}
		if (!pasteFile.exists()) {
			try {
				pasteFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RandomAccessFile raf1 = new RandomAccessFile(copyFile, "r");
		RandomAccessFile raf2 = new RandomAccessFile(pasteFile, "rw");
		try {
			long start = System.currentTimeMillis();
			int bytes = 0;
			while ((bytes = raf1.read()) != -1) {
				raf2.write(bytes);
			}
			long end = System.currentTimeMillis();
			System.out.println("文件拷贝完毕,总共用时：" + (end - start) + "毫秒");
			raf1.close();
			raf2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
