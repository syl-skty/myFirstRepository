package �������л��뷴���л�����;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("С��", 16, "��");
		try {
			WriteObjAndWriteObj.WriteStudent(s, new File(
					"D:\\�ļ����������ļ���\\���л��뷴���л�\\student1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			WriteObjAndWriteObj.ReadStudent(new File(
					"D:\\�ļ����������ļ���\\���л��뷴���л�\\student1"));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
