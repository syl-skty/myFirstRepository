package semaphore���ʹ��;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * semaphore���ʾJava�е��źŵƻ��ƣ���һ��semaphore���������˹�ִͬ�еĸ�����Ҳ�����ܵ�������
 * ���ǿ����˵�ǰ������Դ�ĸ�����ͬʱִ���̵߳ĸ���(�ܵ���)
 * ���磺����������ͬʱִ���̵߳ĸ���Ϊ3������5���߳�Ҫִ��ʱ�����Ȼ���3���߳������У�ʣ����������������һ���߳�ִ����ɺ󣬾ͻ��������������һ�����油
 * 
 * @author skty
 * 
 */
public class Semaphore_Test {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);// ����һ���źŵƶ��󣬲����������Ϊ����Ҳ����ͬʱ���еĸ���Ϊ��
		for (int i = 0; i < 9; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();// ��ǰ�̻߳�ȡһյ�ƣ�����ȫ����ȡ��ʱ�����ڴεȴ���һ���е�ʱ�ͻᱻ����
						System.out.println("��ǰ�߳�"
								+ Thread.currentThread().getName()
								+ "�ѻ�ȡһյ��,ʣ�����Ϊ��"
								+ (3 - semaphore.availablePermits()));
						Thread.sleep(new Random().nextInt(10000));
						semaphore.release();// ��ǰ�߳��ͷ�����ȡ�ĵƣ�ͬʱ�������������е�һ���߳�
						System.out.println("��ǰ�߳�"
								+ Thread.currentThread().getName()
								+ "�ѹ黹յ��,ʣ�����Ϊ��"
								+ (semaphore.availablePermits()));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
