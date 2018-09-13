package blockQueue��������;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue�ײ�ʹ�õ���һ����������Ŷ����е����ݣ�
 * 
 * ʹ��һ��ReentrantLock���������������������ݵĴ�ȡ���п��ƣ�
 * 
 * �ֱ�ʹ��ReentrantLock���󴴽�����Condition�������ֱ���ö�����ʱ�������̺߳ʹ�����ʱ�������߳�
 * 
 * ÿ�γɹ��������ݺ󣬵��ò������ݵ�����������Condition�����е�signal()�������Բ����������������н��л��ѣ���ȡʧ���򽫵�ǰ�̼߳�������ݵ�����Condition������
 * 
 * �������ݸ���ȡ��������
 * 
 * 
 * @author skty
 *
 */
public class BlockQueueTest {

	// ����һ������ʽ���������У�����ָ���������е�������ͬʱ����ָ���Ƿ�Ϊ��ƽ�Ķ���
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3, true);

	public static void main(String[] args) {
		final BlockQueueTest test = new BlockQueueTest();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					int value = new Random().nextInt(100);
					test.put(value);

				}
			}).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					test.get();
				}
			}).start();
		}
	}

	public void put(int value) {
		try {

			// �����������е�put�����Ӷ����в������ݣ�����������ˣ����õ�ǰ�߳̽����������������������ʱ����ȥ������Щȡ���ݵ��߳�
			queue.put(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�����߳�" + Thread.currentThread().getName() + "���ڲ�������" + value + "��������");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int get() {

		int value = 0;
		try {

			// ������������ȡ���ݣ���������������ʱ����������������ɹ�ȡ������ʱ����ȥ������ЩҪ�������ݵ��߳�
			value = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�����߳�" + Thread.currentThread().getName() + "���ڴӶ����ж�ȡ����" + value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}

}
