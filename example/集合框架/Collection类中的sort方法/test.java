package Collection���е�sort����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1.ʵ�ֽӿ�comparable ����compareTo()����
//2.ʵ�ֽӿ�comparator ����compare()����
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s1 = new student(15, "С��");
		student s2 = new student(11, "С��");
		student s3 = new student(17, "С��");
		student[] s = { s1, s2, s3 };
		List<student> l1 = new ArrayList<student>();
		book b1 = new book(2, "����");
		book b2 = new book(3, "Ӣ��");
		book b3 = new book(1, "����");
		List<book> l2 = new ArrayList<book>();
		book[] b = { b1, b2, b3 };
		l1.addAll(Arrays.asList(s));
		l2.addAll(Arrays.asList(b));
		Collections.sort(l1);
		bookCompare bc = new bookCompare();// ����book�Զ���ıȽ϶���
		Collections.sort(l2, bc);// ��Collection.sort(list����,����Ĺ������)��ʵ��
		System.out.println("student�����������");
		for (student stu : l1) {
			System.out.println(stu);
		}
		System.out.println("book�����������");
		for (book bo : l2) {
			System.out.println(bo);
		}
	}

}
