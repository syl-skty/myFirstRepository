package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Map �д�ŵ���һ�ԶԵļ�ֵ��<key,value>,һ��keyֻ��ָ��һ��value����һ��value���Զ�Ӧ���key,key��value������Ϊnull
//Map��ʵ����ΪHashMap
//Map�еļ�ֵ�Դ��ΪEntry����,EntryΪһ����
public class testMap {
	public void MapTest() {
		// ����Map���ͣ���key ����Ϊ���ͣ�����ŵ�value�涨Ϊstudent����
		// ��Ϊ�����������Ͳ���ʹ�÷��ͣ��������ﲻ��int Ҫʹ�����װ��Integer
		Map<Integer, student> students = new HashMap<Integer, student>();
		student s1 = new student(1, "qqq", 12);
		student s2 = new student(2, "www", 15);
		students.put(1, s1);// ����put()���������Ԫ��
							// ʹ��remove(keyֵ)������ɾ��key��Ӧ�ļ�ֵ��,ʹ��put(key���޸ĺ�Ķ���)���޸�
		students.put(2, s2);
		System.out.println("ȡ��keyΪ1��valueΪ��" + students.get(1).toString());// ����get(keyֵ)����ȡ��Ӧ��valueֵ

		// ����Map�е�keySet()��������ȡ����keyֵ�ļ��Ϸ���ΪSet����
		Set<Integer> keyset = students.keySet();
		System.out.println("���е�keyֵΪ��");
		for (int a : keyset) {
			System.out.print(" " + a);
		}
		System.out.println();
		// ����entrySet()���������еļ�ֵ��,����ֵΪ��������ΪEntry���͵�Set(����)����Set<Entry>����
		Set<Entry<Integer, student>> entrySet = students.entrySet();// ǰ��ļ�ֵ��Ϊ<Integer,student>����,����ҲҪһ��
		System.out.println("Map�����еļ�ֵ��Ϊ��");
		for (Entry<Integer, student> e : entrySet) {
			System.out.println("��Ϊ��" + e.getKey() + ";ֵΪ��" + e.getValue());
		}
	}
}
