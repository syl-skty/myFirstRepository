package cyclicaBarrier�������ʹ��;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier ��������ǿ����ö���߳���ͬһʱ�̼��ϣ�������ǰִ��
 * ��cyclicBarrier�������õ��̵߳�����Ϊ3ʱ������һ���߳��ȵ���ȴ��Ĵ���ʱ��
 * ��ȴ����������̣߳������һ���߳�ִ�е��ȴ����߳�ʱ����ʱ����ǰ�����ȵ����������̣߳������߳�һ��ִ��
 * 
 * @author skty
 * 
 */
public class CyclicBarrier_Test {
	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);// ����һ��CyclicBarrier���󣬲�������һ�����е��߳�Ϊ����
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(new Random().nextInt(10000));
						System.out.println("��ǰ�߳�Ϊ"
								+ Thread.currentThread().getName()
								+ "�Ѿ����е����ϵ㣬�ȴ����̸߳���Ϊ"
								+ cyclicBarrier.getNumberWaiting());
						System.out
								.println(cyclicBarrier.getNumberWaiting() == 2 ? "�������"
										: "");
						cyclicBarrier.await();// ���ô˷���������ǰ�浽���߳��ڴ˴��������������̶߳���ʱ�����������̣߳�ͬʱִ��
						System.out.println("���");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}

	}

}
