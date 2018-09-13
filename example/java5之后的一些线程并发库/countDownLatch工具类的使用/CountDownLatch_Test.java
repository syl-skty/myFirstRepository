package countDownLatch�������ʹ��;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * ����Ķ����൱��һ����ʱ��������ʱ����ʱΪ0ʱ�����б��������߳̽���ͬʱ���Ѳ�ִ��
 * ����ļ���ʹ�õ��ǣ����е�countDown()�����������ü�ʱ���ļ�����һ
 * 
 * @author skty
 * 
 */
public class CountDownLatch_Test {

	public static void main(String[] args) {
		final CountDownLatch c1 = new CountDownLatch(1);// ����һ��CountDownLatch���󣬲����������Ϊ3
		final CountDownLatch c2 = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("�߳�"
								+ Thread.currentThread().getName()
								+ "��׼����ϣ��ȴ�����");
						c1.await();// ����c1��await()���������������߳��ڴ˵ȴ���ʱ�������������
						Thread.sleep(new Random().nextInt(10000));
						System.out.println("�߳�"
								+ Thread.currentThread().getName() + "�ѵ���");
						c2.countDown();// ����countDown����������c2�ļ�����һ���������̶߳�ִ�е�����ʱ����c2���ȴ��������̱߳�����ִ��
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		try {
			Thread.sleep(1000);// ���߳�˯��һ��
			c1.countDown();// ����c1��countDown()��������ǰ�汻�����������߳�ͬʱ������ִ��
			c2.await();// ����c2��await()���������̵߳ȴ���ʱΪ3�ļ�ʱ���������ִ��
			System.out.println("�����߳�ִ����ϣ�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
