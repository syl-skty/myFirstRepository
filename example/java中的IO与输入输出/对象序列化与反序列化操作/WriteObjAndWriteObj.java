package 对象序列化与反序列化操作;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteObjAndWriteObj {
	/**
	 * 将对象序列化的函数
	 * 
	 * @param student
	 *            要序列化的对象
	 * @param file
	 *            要保存的文件
	 * @throws IOException
	 */
	public static void WriteStudent(Student student, File file)
			throws IOException {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				file));// 创建序列化流对象
		out.writeObject(student);// 序列化对象
		out.close();
		System.out.println("序列化成功！");
	}

	/**
	 * 反序列化对象并打印出来
	 * 
	 * 
	 * @param file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void ReadStudent(File file) throws IOException,
			ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));// 创建反序列化流对象
		Student student = new Student();
		student = (Student) in.readObject();// 反序列化对象
		System.out.println(student.toString());
		in.close();
	}
}
