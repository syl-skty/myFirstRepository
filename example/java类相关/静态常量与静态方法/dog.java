package ��̬�����뾲̬����;

public class dog {
	static int age = 3;
	String name;

	public dog(String name) {
		this.name = name;
	}

	public static void show() {
		dog d1 = new dog("����");
		System.out.println("my name is " + d1.name);// ��̬����ʹ��ͬ���еķǾ�̬����ʱ����ֱ��ʹ�ã����봴������������
		d1.cut();// ��̬�����޷�ֱ�ӵ��ñ����еķǾ�̬���������봴������������
		System.out.println("my age is " + age);// ��̬��������ֱ��ʹ�ñ����еľ�̬����
		cut2();// ��̬��������ֱ�ӵ��ñ����еľ�̬����
		System.out.println("�½�����d1����static��ֵΪ��" + dog.age);
	}

	public void cut() {
		System.out
				.println("....................................................");
	}

	public static void cut2() {
		System.out
				.println("****************************************************");
	}
}
