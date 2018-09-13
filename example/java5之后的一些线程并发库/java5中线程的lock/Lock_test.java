package java5���̵߳�lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_test {
	public static void main(String[] args) throws Exception {
		final lock l = new lock();

		new Thread(new Runnable() {

			@Override
			public void run() {
				l.say();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				l.talk();
			}
		}).start();

	}

}

class lock {
	private Lock lock = new ReentrantLock();// ����һ���������������ʱ���൱�ڶ�����������

	public void say() {
		lock.lock();// ����lock()�������ڵ�ǰ�߳��ϸ�lock������������������߳̾Ͳ����ڵ�ǰ�߳�ִ���������ʱ��ϵ�ǰ�̵߳�ִ��
		try {// ʹ��try����ֹ�ڵ�ǰ�߳�ִ����������ʱ�����쳣�������޷��ͷŵ�ǰ��
			for (int i = 0; i < 100; i++) {
				System.out.println("�����߳�" + Thread.currentThread().getName() + "��ִ��say()����");
			}
		} finally {
			lock.unlock();
		}
	}

	public void talk() {
		lock.lock();
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println("�����߳�" + Thread.currentThread().getName() + "��ִ��talk()����");
			}
		} finally {
			lock.unlock();
		}
	}

}
