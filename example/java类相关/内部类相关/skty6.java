package �ڲ������;

import �ڲ������.dog.sdog;

//�ⲿ�಻��ֱ�ӷ����ڲ���ĳ�Ա�ͷ���
public class skty6 {
	int a = 3;
	static String b = "ƤƤ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		skty6 s6 = new skty6();
		cat cat1 = s6.new cat();// ������Ա�ڲ���Ķ���ʱ�����ȴ����ⲿ��Ķ���ʹ�ã��ڲ��� �ڲ��������=�ⲿ�����.new
								// �ڲ���()��
		cat1.show();
		// ��������������������������������������������������������������������������������������������������
		sdog s = new sdog();// �˴�Ҫimport dog���е�sdog,�����ⲿ��.new ����,ֱ�Ӹ���ͨ��һ������
		s.show();
	}

	public void cut() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	public class cat// ��Ա�ڲ���
	{
		String name;
		int age;

		public void show() {
			name = b;// ��Ա�ڲ������ֱ�ӷ����ⲿ������Ժͷ��������ⲿ�಻�ܷ����ڲ��������
			age = a;
			cut();
			System.out.println("name:" + name + "   age:" + age);
		}

	}

}
