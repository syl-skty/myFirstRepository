package Collection���е�sort����;

//Collection.Sort()�������Զ�List�е�Ԫ�ذ�һ����˳������
//���List�д�ŵ��ǻ����������ͣ���ֱ��ʹ�÷�������
//����ŵ����Զ������ʱҪ������������ͱ����ö������ڵ���ʵ��comparable�ӿڣ���дcompareto()�����������Զ���Ϊ�Լ��涨�ĶԱȹ���
public class student implements Comparable<student> {
	int age;
	String name;

	public student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	// ��дcompareTo����ʵ�ֱȽ����������age
	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		// ��age����Integer��װ���Ѿ�д�õ�compareTo()�������Ƚ�����age�Ĵ�С��������һ��ֵ��Ҳ����if������ж�����age�Ĵ�С
		return ((Integer) this.age).compareTo(o.age);
	}

	@Override
	public String toString() {
		return "student [age=" + age + ", name=" + name + "]";
	}

}
