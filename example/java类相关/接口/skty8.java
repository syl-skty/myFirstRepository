package �ӿ�;

//һ���ӿڿ��Լ̳ж�����ӿ�
//һ�������ʵ�ֶ���ӿڣ����ֲ���һ����ֻ�ܼ̳�һ������Ĳ���
public class skty8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �÷�1:����ʵ��������ýӿڵ����óнӣ���ʵ�ֽӿ�
		duck dk = new smallDuck("С��");
		dk.fly();
		new smallDuck("����").say();// ����ֱ�Ӵ������󣬲��нӣ�Ҳ����ֱ�ӵ��ú���

		// �÷�2:���������ڲ���ķ�ʽ��ʵ�ֽӿ�
		bird b = new bird() {

			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("��ʹ�������ڲ���ķ�ʽʵ����walk()����");
			}

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("��ʹ�������ڲ���ķ�ʽʵ����fly()����");
			}

		};
		b.walk();// �ڴ�������ʱֱ��ʵ�ֽӿ��еķ�����������

		// Ҳ����
		new animal() {
			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("ʵ����animal�ӿ�");
			}

		}.walk();
	}

}
