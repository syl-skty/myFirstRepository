package indexOf������ʵ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//indexOf(ָ������)�����Ĺ����Ƿ��ض����ڼ����е�����ֵ��ͬ����Ҫ�Ƚ϶�������Զ�����ָ���ַ������дequals()����
//lastIndexOf()��������������λ��
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s1 = new student(1, "С��");
		student s2 = new student(2, "С��");
		student s3 = new student(2, "С��");
		List<student> students = new ArrayList<student>();
		student[] s = { s1, s2, s3 };
		students.addAll(Arrays.asList(s));
		student stu = new student(2, "С��");
		System.out.println("ָ��������List�еĵ�һ������λ��Ϊ��" + students.indexOf(stu));
		System.out.println("ָ��������List�е����һ������λ��Ϊ��" + students.lastIndexOf(stu));
	}

}
