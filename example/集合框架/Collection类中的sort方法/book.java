package Collection���е�sort����;

//ʵ��comparator�ӿڲ�ʵ���䷽��compare(object o1,object o2)

public class book {
	int num;
	String name;

	public book(int num, String name) {
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "book [num=" + num + ", name=" + name + "]";
	}

}
