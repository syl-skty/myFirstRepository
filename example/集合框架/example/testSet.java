package example;

import java.util.HashSet;
import java.util.Set;

//set�ӿڴ�ŵ�Ԫ��Ϊ�����ظ�������ģ� ����Ϊ����,����set�е�Ԫ�����򣬼�Ԫ��û���±�index.
//set�ӿڴ���һ��ʵ����HashSet,
public class testSet {
	public void Settest() {
		Set<student> students = new HashSet<student>();// ����Set students(����)
		student s1 = new student(1, "bob", 13);
		student s2 = new student(2, "tom", 17);
		student s3 = new student(3, "mike", 15);
		students.add(null);// set�п��Դ��null
		students.add(s1);// ����ָ��λ�ò��룬��ΪsetΪ�����
		students.add(s2);
		students.add(s2);
		students.add(s3);
		// ����Set students,ʹ��foreach,������for()���:û���±�
		System.out.println("set student �е�Ԫ��Ϊ��");
		for (student s : students) {
			System.out.println(s);
		}
		students.remove(s2);// ɾ��ָ��Ԫ��
		System.out.println("ɾ��s2��Set�е�Ԫ��Ϊ��");
		for (student s : students) {
			System.out.println(s);
		}
	}
}
