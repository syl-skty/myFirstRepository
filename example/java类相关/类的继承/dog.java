package ��ļ̳�;


public class dog extends animal {
	int age;

	public dog(int age, String color) {
		super();// ��������д���췽��ʱ���ڹ��췽���ĵ�һ��Ҫ���ø�����޲ι��캯��(super����),��ΪҪ�������������Ҫ���ø������ζ����������������
		this.age = age;
		this.color = color;
	}

	public void show()// ������д����д����ķ���
	{
		super.say();// ��super�����࣬���ø��෽������ʱֱ����(super.����/����)
		System.out.println("I am a dog");
	}

	@Override
	public String toString()// object����������ĸ��࣬���涨����toString��������д�˷�������ֱ����System.out.println(����)��ӡ��������������ԣ��������д�������Ϊ����洢�ĵ�ַ
	{
		return "dog [age=" + age + "  color=" + color + "   food=" + food + "]";
	}

	public boolean equals(Object obj)// object����������ĸ��࣬���涨����equals��������д�˷��������ж����������Ƿ���ͬ
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		return true;
	}
}
