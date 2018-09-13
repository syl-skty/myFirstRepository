package file���ʹ��;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �˹������а������ļ�Ŀ¼����ز���
 * 
 * @author ʷ����
 * 
 */
public class FileUtil {

	public static void printSpace(int path) {
		for (int i = 1; i < path; i++) {
			System.out.print("   ");
		}
	}

	/**
	 * �����ļ��л��ļ�
	 * 
	 * @param filePathҪ�����ļ���·��
	 */
	public static void Mkdir(String filePath, String type) {

		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("�ļ����ļ����Ѵ��ڣ�");
			return;
		} else {
			switch (type) {
			case "�ļ���":
				file.mkdir();// �����ļ���
				System.out.println("�ļ���" + file.getName() + "�����ɹ���");
				break;
			case "�ļ�":
				try {
					file.createNewFile();// �����ļ�
					System.out.println("�ļ�" + file.getName() + "�����ɹ���");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("���봴�����ʹ���");
				break;
			}
		}
	}

	/**
	 * �����ļ����µ������ļ���Ŀ¼
	 * 
	 * @param file
	 *            Ҫ�������ļ���
	 * @param path
	 *            �����ļ��еĳ�ʼ���
	 */
	public static void listFiles(File file, int path) {
		if (!file.exists()) {
			throw new IllegalArgumentException("�����ļ��л��ļ�������!");
		}
		printSpace(path);
		if (path != 1)
			System.out.println("��" + file.getName());
		else
			System.out.println(file.getName());
		if (!file.isDirectory()) {
			return;
		}
		File[] files = file.listFiles();
		List<File> fileList = new ArrayList<File>();
		if (files != null && files.length > 0) {
			for (File file2 : files) {
				if (file2.isDirectory()) {
					fileList.add(file2);
				} else {
					printSpace(path);
					System.out.println("   ��" + file2.getName());
				}
			}
		}
		class fileCompare implements Comparator<File> // ���巽�ڲ���ʵ�ָ��������ļ���Ŀ¼��������������Ĺ���
		{
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				return ((Integer) o1.list().length).compareTo(o2.list().length);
			}

		}
		fileCompare fc = new fileCompare();// ʹ�÷����ڲ��ഴ������ʱ�����ȴ�����
		Collections.sort(fileList, fc);// �����¹����������
		for (File file2 : fileList)// �����������ļ�������Ŀ¼
		{
			listFiles(file2, path + 1);
		}
	}

	public static void listFiles(File file)// �ع�������Ĭ����ȸ�ֵΪ1
	{
		int path = 1;// �Ƚ�path��ֵ��ֵΪ1
		listFiles(file, path);// Ȼ�����ʵ��Ҫִ�еķ���
	}

}
