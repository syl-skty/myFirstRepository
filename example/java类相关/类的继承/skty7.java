package ��ļ̳�;

public class skty7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		animal a = new animal();
		animal a1 = new dog(3, "white");
		animal a2 = new cat();
		// ��̬ʵ��
		System.out.println("��̬ʵ��");
		a.show();// ����animal �е�show()
		a1.show();// ����dog�е�show()
		a2.show();// ����cat�е�show()

		// ����dog����д��toString equals����
		System.out.println("����dog����д��toString equals����");
		System.out.println(a1);
		if (a1.equals(a2))
			System.out.println("dog���������������ͬ");

		// ���ת��
		System.out.println("���ת��");
		animal a3 = a1;// �������ֱ��ת��Ϊ�������ֻ�����ͬ�����Խ��ܣ�������û�е����Է����ᱻ����
		a3.show();// ��ʱ��show()Ϊ��������е�show()�����Ǹ����е�
		// dog d1=(dog)a;//����ת��Ϊ����Ҫʹ��ǿ������ת���������з��ձ���

		if (a1 instanceof cat)// ��instanceof���ж�������ɲ�����ת����������Է���true
		{
			a1 = a2;
		} else
			System.out.println("�޷����cat��dog��ת��");

	}

}
