package ����̹߳���һ������;

public class ShareDate2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Myrunnable());
		Thread t2 = new Thread(new Myrunnable());

		t1.start();
		t2.start();

	}

}

class Myrunnable implements Runnable {
	public static int shareDate = 100;// ������̶߳�Ҫ����ͬ�ķ�ʽ����һ������ʱ��������һ����ʵ��Runnable�ӿڣ�Ȼ����ʵ�����м�һ�����������湲�����

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			synchronized (Myrunnable.class) {

				System.out.print("��ǰ�߳�Ϊ" + Thread.currentThread().getName()
						+ " ����ǰ������Ϊ" + shareDate);
				shareDate--;
				System.out.println("��ǰ�߳�Ϊ" + Thread.currentThread().getName()
						+ " �����������Ϊ" + shareDate);
			}
		}
	}

}