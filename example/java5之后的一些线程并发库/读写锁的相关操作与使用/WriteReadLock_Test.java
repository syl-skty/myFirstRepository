package ��д������ز�����ʹ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ͨ����д����ʹ�ã������Ǵ���һ����д������ʱ���������ж���̶߳���ʹ��ͬһ����д������ʱ��һ���̶߳Զ�д�������϶�����������������
 * �Զ�д�������϶������߳�һ��ִ�У��������Ǵ�������У�����������ЩҪ�Զ�д��������д�����߳����С�
 * ��һ���̶߳Զ�д����������д�����Ͳ����������κ�Ҫ�Զ�д�������϶�����д�����߳����У�����ȴ�д���ͷź���ܲ���
 * 
 * ��ʵ��java5�߳��еĶ�д�������������˶�����ʱ�����ȥ�����ݣ�����д���ľͱ���ȥд���ݣ���ֻ��һ�����߳����й�ϵ�ı�ʾ
 * ��ʾһЩ�߳�����ʱ����������һЩ�߳�һ�����У���������һЩ�߳�һ�����С���������˶����ݵĶ�д�Ĺ���������
 * 
 * @author skty
 * 
 */
public class WriteReadLock_Test {

	public static void main(String[] args) {
		final Work w = new Work();
		ExecutorService threadpool = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			threadpool.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					w.read();
					w.write();
				}
			});
		}
		threadpool.shutdown();
	}
}

class Work {
	// ����һ����д�����󣬵�����߳�ʹ��ͬһ����д��ʱ�������ж�д��Ч��
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public void read() {
		rwl.readLock().lock();// ��ǰ�̶߳Զ�д�������϶�������������ʹ��ͬһ����д�������϶������߳�ͬ�����У�����������д�����߳�����
		try {// ʹ��try��䣬��ֹ�ڳ����쳣ʱ���޷��ͷŵ�ǰ����
			System.out.println("�߳�" + Thread.currentThread().getName()
					+ "��ʼ������");
			System.out.println("�߳�" + Thread.currentThread().getName()
					+ "���������");
		} finally {
			rwl.readLock().unlock();
		}
	}

	public void write() {
		rwl.writeLock().lock();// ��ǰ�̶߳Զ�д��������д������ʱ�����������κζ�д���߳����У�����ȴ�
		try {
			System.out.println("�߳�" + Thread.currentThread().getName()
					+ "��ʼд����");
			System.out.println("�߳�" + Thread.currentThread().getName()
					+ "д�������");
		} finally {
			rwl.writeLock().unlock();
		}
	}
}