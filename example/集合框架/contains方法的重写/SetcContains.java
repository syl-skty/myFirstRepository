package contains��������д;

//Set����Ϊû���±꣬����Ҫ����HashCode()�������Ƚ����ϣ���Ƿ���ͬ������ͬ���ٵ���equals()�������Ƚ�
//Ҫʵ��contains()���ã���Ҫ��дhashCode()������equals()����
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetcContains {
	public void testContains() {
		Set<course> courses = new HashSet<course>();
		course c1 = new course(1, "����");
		course c2 = new course(2, "Ӣ��");
		course c3 = new course(3, "�ִ�");
		course[] c = { c1, c2, c3 };
		courses.addAll(Arrays.asList(c));
		course c4 = new course(3, "����");
		course c5 = new course(2, "Ӣ��");
		System.out.println("Set���Ƿ����" + c4 + ":" + courses.contains(c4));
		System.out.println("Set���Ƿ����" + c5 + ":" + courses.contains(c5));
	}
}
