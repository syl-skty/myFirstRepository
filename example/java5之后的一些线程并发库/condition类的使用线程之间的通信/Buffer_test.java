package condition���ʹ���߳�֮���ͨ��;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �Զ����һ���������С� ��ʹ��Conditionʱ��������Condition�����һ��lock.lock������lock.unlock()����ȡ���������
 * ��Ȼ�ᱨ�쳣 java.lang.IllegalMonitorStateException
 * 1>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.wait()����; 2>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notify()������
 * 3>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notifyAll()����
 * �����Condition���ڲ���ʹ��Object��wait()��notify()������ʵ�ֵ�
 * 
 * �����̣߳�һ���̸߳����һ������д�����ݣ���һ���̸߳����ͬһ������������ݡ�������ĳ���С�������̵߳�����һ�������� ����ʹ�������̶߳�����ʵ�֣�
 * ��д�����д�����ݺ󣬴Ӷ������ݵ����������л���һ�����������߳�ȥ�����ݣ� ���������̶������ݺ󣬴�д�����ݵ����������л���һ��д���̳߳�ȥд����
 * ����������ʱ��д����̵���await()���������������У�ͬʱ�˷���������������߳���ѡ��һ���߳�ִ�У�
 * ������Ϊ��ʱ���������̵���await()���������������У�ͬʱ�˷���������������߳���ѡ��һ���߳�ִ�У�
 * 
 * @author skty
 * 
 */
public class Buffer_test {
	public static void main(String[] args) {
		final buffer b = new buffer();
		for (int i = 0; i < 200; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						b.readData();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		for (int j = 0; j < 200; j++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						int data = new Random().nextInt(1000);
						b.writeData(data);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

	}
}

class buffer {
	private Object[] buffer = new Object[10];// ����һ���������ڱ��������ߺ������ߵ�����
	private int dataCount, takeptr, putptr = 0;// �����Ա������ݵ�������ȡ���ݵ�ָ�룬�����ݵ�ָ��
	Lock lock = new ReentrantLock();// ����һ����
	Condition read = lock.newCondition();// ����һ����Ų��������������ʱ�������Щ����ִ�еĶ����ݲ���ʱ���̵߳���������
	Condition write = lock.newCondition();// ����һ����Ų�����д��������ʱ�������Щ����ִ��д���ݲ������̵߳���������

	public Object readData() throws InterruptedException {
		lock.lock();// ��һ���߳̽��ж����ݲ���ʱ����ֹ�����߳�Ҳ�������ݣ����Խ�����Ĵ������
		try {
			while (dataCount == 0)
				// ʹ��while��䣬��ֹ�̱߳��ٻ��ѣ�����ж�
				// ���������������Ϊ��ʱ���޷������ݣ�����ǰ�̷߳����������������������У�ͬʱ�����ȥ���ѽ����е������̣߳���������д�߳�
				read.await();
			Object x = buffer[takeptr];// ������ʱ����������ȥ��Ӧָ�������

			if (++takeptr == buffer.length) {// ����ָ���֮ǰָ��������һ��λ��ʱ������һ�ε�ָ��ָ���һ��λ��
				takeptr = 0;
			}
			--dataCount;// ���ݵĸ�����һ
			System.out.println("��ȡ����" + x + "  ��ǰ����Ϊ��" + dataCount);
			write.signal();// ͬʱ��Ҫд�̵߳��������з��źţ���д�̵߳��������л���һ���̣߳�ִ��д����
			return x;
		} finally {
			lock.unlock();// �����ͷţ�����һ��Ҫ�����ݵ��߳�ִ��
		}
	}

	public void writeData(Object data) throws InterruptedException {
		lock.lock();// ��һ���߳̽���д���ݲ���ʱ����ֹ�����߳�Ҳ��д���ݣ����Խ�����Ĵ������
		try {
			while (dataCount == buffer.length)
				// ʹ��while��䣬��ֹ�̱߳��ٻ��ѣ�����ж�
				// ���������Ѿ��������ݺ󣬽���ǰд���ݵ��̷߳��룬д�̵߳���������
				write.await();
			buffer[putptr] = data;// �����ݴ洢��дָ���Ӧ��λ��

			if (++putptr == buffer.length)// ����һ��дָ��ָ��������һ��λ��ʱ������һ��Ҫд��λ����Ϊ���鿪ͷ
			{
				putptr = 0;
			}
			++dataCount;// ����������һ
			System.out.println("д������" + data + "  ��ǰ����Ϊ��" + dataCount);
			read.signal();// д�����ݺ󣬷��źŸ���Щ����û���ݶ����������ڶ������������е��̣߳��������е�һ���߳�
		} finally {
			lock.unlock();// ��ǰ�߳��ͷ���������һ��д���ݵ��߳���ִ��
		}
	}
}
