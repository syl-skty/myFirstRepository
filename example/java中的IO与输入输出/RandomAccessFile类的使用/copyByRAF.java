package RandomAccessFile���ʹ��;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class copyByRAF {
	/**
	 * ʹ��RandomAccessFile�ķ�ʽ�����ļ�(�ֶ����û�����)
	 * 
	 * @param copyFile
	 *            Ҫ���������ļ�
	 * @param paste
	 *            ���������ļ�
	 * @throws FileNotFoundException
	 */
	public static void copyFile(File copyFile, File pasteFile)
			throws FileNotFoundException {
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("��Ҫ�������ļ������ڻ����ļ���");
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
		byte[] buf = new byte[1024 * 100];// �ֶ����õĻ�������СӦ������
		try {
			long start = System.currentTimeMillis();
			while (raf1.read(buf) != -1) {
				raf2.write(buf);
			}
			long end = System.currentTimeMillis();
			System.out.println("�ļ��������,�ܹ���ʱ��" + (end - start) + "����");
			raf1.close();
			raf2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����һ���ֽ�һ���ֽڵķ�ʽ�����ļ�
	 * 
	 * @param copyFile
	 * @param pasteFile
	 */
	public static void copyFileByByte(File copyFile, File pasteFile)
			throws FileNotFoundException {
		if (!copyFile.isFile() || !copyFile.exists()) {
			throw new IllegalArgumentException("��Ҫ�������ļ������ڻ����ļ���");
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
			System.out.println("�ļ��������,�ܹ���ʱ��" + (end - start) + "����");
			raf1.close();
			raf2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
