package exchanger�������ʹ��;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Exchanger_Test {
	public static void main(String[] args) {
		// ����һ��Exchanger���󣬲�ָ���������ݵ�����ΪString
		final Exchanger<String> exchanger = new Exchanger<String>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "���";
					Thread.sleep(new Random().nextInt(10000));
					System.out.println(Thread.currentThread().getName()
							+ "�ѵ��ｻ�׵ص�");
					// ����һ���߳�ִ�е��˴�ʱ����������ڴ�֮ǰû�������߳�ִ�е�exchange����������
					// �ͱ��������ȴ���һ��ִ�е�exchange�����������̣߳�����֮��������
					String d = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()
							+ "������ɣ��õ�" + d);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "�ֵ�";
					Thread.sleep(new Random().nextInt(10000));
					System.out.println(Thread.currentThread().getName()
							+ "�ѵ��ｻ�׵ص�");
					String d = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()
							+ "������ɣ��õ�" + d);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}
}
