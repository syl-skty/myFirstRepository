package ����̹߳���һ������;

//����̹߳���һ������������߳�������ʱҪ����ͬһ���������������߳�֮����໥���š�
//�������Ӿ�����Ʊϵͳ��Ʊ���ڶ����Ʊ�߳�����ʱ����
public class Multi_thread_shareDate {
	private static int shareDate = 100;// �������涨��һ����������ԣ�ÿ���̶߳������������

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				plus();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				decrise();
			}
		}).start();
	}

	public static void plus() {// �����Ǿ�̬���������Լ���ʱʹ�õ���������ʹ��.class���жԴ�������
		for (int i = 0; i < 5; i++) {
			synchronized (Multi_thread_shareDate.class) // ��synchronized�ؼ���Ϊ����ӹ��̵Ĵ�����������ֹ��һ���߳̽��мӲ����ʹ�ӡ����ʱ���������̴߳��
			{
				System.out.print("�������ݼӲ���ǰ��ֵΪ��" + shareDate);
				shareDate++;
				System.out.println("������Ϊ" + shareDate);
			}
		}
	}

	public static void decrise() {
		for (int i = 0; i < 5; i++) {
			synchronized (Multi_thread_shareDate.class) {
				System.out.print("�������ݼ�����ǰ��ֵΪ��" + shareDate);
				shareDate--;
				System.out.println("��������Ϊ" + shareDate);
			}

		}
	}

}
