package contains��������д;

import java.util.HashMap;
import java.util.Map;

//Map�е�contains()����������containsKey()��containsValue()����
//�����������������ǵ���equals()�����������жϵ�
public class MapContains {
	public void testMap() {
		Map<Integer, course> courses = new HashMap<Integer, course>();// ���巺��,����keyҪ�ð�װ�࣬value��course��
		course c1 = new course(1, "����");
		course c2 = new course(2, "����");
		course c3 = new course(3, "�ߴ�");
		course[] c = { c1, c2, c3 };
		for (int i = 0; i < 3; i++) {
			courses.put(i, c[i]);
		}
		course c4 = new course(2, "����");
		System.out.println("value�Ƿ����" + courses.containsValue(c4));
		System.out.println("key�з����" + courses.containsKey(2));
	}
}
