package �������л��뷴���л�����;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteObjAndWriteObj {
	/**
	 * ���������л��ĺ���
	 * 
	 * @param student
	 *            Ҫ���л��Ķ���
	 * @param file
	 *            Ҫ������ļ�
	 * @throws IOException
	 */
	public static void WriteStudent(Student student, File file)
			throws IOException {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				file));// �������л�������
		out.writeObject(student);// ���л�����
		out.close();
		System.out.println("���л��ɹ���");
	}

	/**
	 * �����л����󲢴�ӡ����
	 * 
	 * 
	 * @param file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void ReadStudent(File file) throws IOException,
			ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));// ���������л�������
		Student student = new Student();
		student = (Student) in.readObject();// �����л�����
		System.out.println(student.toString());
		in.close();
	}
}
