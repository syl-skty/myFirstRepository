package file类的使用;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 此工具类中包含对文件目录的相关操作
 * 
 * @author 史永龙
 * 
 */
public class FileUtil {

	public static void printSpace(int path) {
		for (int i = 1; i < path; i++) {
			System.out.print("   ");
		}
	}

	/**
	 * 创建文件夹或文件
	 * 
	 * @param filePath要创建文件的路径
	 */
	public static void Mkdir(String filePath, String type) {

		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("文件或文件夹已存在！");
			return;
		} else {
			switch (type) {
			case "文件夹":
				file.mkdir();// 创建文件夹
				System.out.println("文件夹" + file.getName() + "创建成功！");
				break;
			case "文件":
				try {
					file.createNewFile();// 创建文件
					System.out.println("文件" + file.getName() + "创建成功！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("输入创建类型错误！");
				break;
			}
		}
	}

	/**
	 * 遍历文件夹下的所有文件及目录
	 * 
	 * @param file
	 *            要遍历的文件夹
	 * @param path
	 *            遍历文件夹的初始深度
	 */
	public static void listFiles(File file, int path) {
		if (!file.exists()) {
			throw new IllegalArgumentException("输入文件夹或文件不存在!");
		}
		printSpace(path);
		if (path != 1)
			System.out.println("—" + file.getName());
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
					System.out.println("   —" + file2.getName());
				}
			}
		}
		class fileCompare implements Comparator<File> // 定义方内部类实现根据两个文件子目录的数量进行排序的规则
		{
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				return ((Integer) o1.list().length).compareTo(o2.list().length);
			}

		}
		fileCompare fc = new fileCompare();// 使用方法内部类创建对象时必须先创建类
		Collections.sort(fileList, fc);// 按照新规则进行排序
		for (File file2 : fileList)// 遍历排序后的文件夹与子目录
		{
			listFiles(file2, path + 1);
		}
	}

	public static void listFiles(File file)// 重构方法对默认深度赋值为1
	{
		int path = 1;// 先将path的值赋值为1
		listFiles(file, path);// 然后调用实际要执行的方法
	}

}
