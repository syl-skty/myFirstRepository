package 对象序列化与反序列化操作;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("小明", 16, "男");
		try {
			WriteObjAndWriteObj.WriteStudent(s, new File(
					"D:\\文件操作测试文件夹\\序列化与反序列化\\student1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			WriteObjAndWriteObj.ReadStudent(new File(
					"D:\\文件操作测试文件夹\\序列化与反序列化\\student1"));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
