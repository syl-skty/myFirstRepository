package contains��������д;

//contains()���������ж�ĳ��Ԫ�ؼ����Ƿ����ĳ��ָ��Ԫ��
//ԭ���Ǳ����������ϣ���ÿ��Ԫ��ȥ�����Լ���equals()��������ָ��Ԫ�رȽϡ�
//��δ��д��equals()����ֻ���ж���������ָ��ĵ�ַ�Ƿ���ͬ������Ҫ�Ƚ���Ԫ�ظ���������ͬ��������дequals()����
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListContains {
	public void ListTest() {
		List<course> courses = new ArrayList<course>();
		course c1 = new course(1, "����");
		course c2 = new course(2, "Ӣ��");
		course c3 = new course(3, "�ִ�");
		course[] course1 = { c1, c2, c3 };
		courses.addAll(Arrays.asList(course1));// ������ת��ΪList�����ٵ���addAll�������������Ԫ��
												// Arrays.asList()
		course c0 = new course(2, "C����");
		course c9 = new course(3, "�ִ�");
		System.out.println("List���Ƿ����ָ������Ԫ�أ�" + c0 + "����������������>"
				+ courses.contains(c0));
		System.out.println("List���Ƿ����ָ������Ԫ�أ�" + c9 + "����������������>"
				+ courses.contains(c9));
		course[] course2 = { c1, c2, c9 };
		System.out.println("List���Ƿ����ָ�����Ԫ�أ�" + course2[0] + ";" + course2[1]
				+ ";" + course2[2] + "����������������>"
				+ courses.containsAll(Arrays.asList(course2)));
	}
}
