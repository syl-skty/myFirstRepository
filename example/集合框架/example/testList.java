package example;

//List�д��������ظ��Ķ���Ԫ�ء��ǳ��õļ��ϡ�
//List �ӿڴ�������ʵ���ࣺArrayList ,LinkList. ������������ʵ����������List��������ż������顣
import java.util.ArrayList;
import java.util.List;

public class testList {
	public void Listtest() {
		List<student> students = new ArrayList<student>(); // ���巺�ͣ���List����Ϊ���ͣ�students��ֻ�ܴ��student����Ԫ��
		// ����student���к��ι��췽����������
		student s1 = new student(1, "С��", 15);
		student s2 = new student(2, "С��", 18);
		// ����add()��������students��Ӷ���Ԫ�أ��Զ������ĩβ
		students.add(s1);
		students.add(s2);
		System.out.println("����List students�е�Ԫ��˳��Ϊ��");
		for (int i = 0; i < students.size(); i++)// ����List�е�size������������ȡStudents�ĳ���
		{
			student s = students.get(i);
			System.out.println("λ��" + i + " " + s);// ��ʱֱ��дstudent����s���Զ�������д��toString()����
		}

		student s3 = new student(3, "С��", 12);
		// ����add(λ�ã�����)������һ������
		students.add(2, s3);
		System.out.println("����Ԫ�غ��List students��Ԫ��˳��Ϊ��");
		for (int i = 0; i < students.size(); i++)// ����List�е�size������������ȡStudents�ĳ���
		{
			student s = students.get(i);
			System.out.println("λ��" + i + " " + s);// ��ʱֱ��дstudent����s���Զ�������д��toString()����
		}

		List<student> L1 = new ArrayList<student>();
		L1.add(s2);
		L1.add(s3);
		// ����addAll(λ�ã���һ��List����)������Ԫ�أ�Ҳ������addAll(��һ��List����)��׷����ĩβ
		students.addAll(2, L1);
		System.out.println("������һ��List������studentsԪ��˳��Ϊ��");
		for (int i = 0; i < students.size(); i++)// ����List�е�size������������ȡStudents�ĳ���
		{
			student s = students.get(i);
			System.out.println("λ��" + i + " " + s);// ��ʱֱ��дstudent����s���Զ�������д��toString()����
		}

		student s4 = new student(6, "С��", 20);
		students.set(2, s4);// ����set���� �������޸�Listָ����Ԫ��
		students.remove(3);// ����remove()������ɾ��ָ��λ�õ�Ԫ��
		System.out.println("ִ���޸�ɾ�����studentsԪ��˳��Ϊ��");
		for (int i = 0; i < students.size(); i++)// ����List�е�size������������ȡStudents�ĳ���
		{
			student s = students.get(i);
			System.out.println("λ��" + i + " " + s);// ��ʱֱ��дstudent����s���Զ�������д��toString()����
		}

	}
}
