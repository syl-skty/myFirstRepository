package ��д������ز�����ʹ��;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * �Լ���Ƶ�һ��������
 * 
 * @author skty
 * 
 */
public class CacheTest {
	public static void main(String[] args) {
		final Cache cache = new Cache();
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					cache.getCache(1);
				}
			}).start();
		}
	}
}

class Cache {
	// ����һ��map���������Լ�ֵ�Եķ�ʽ������Ҫ���������
	private Map<Integer, Object> cache = new HashMap<Integer, Object>();
	// ����һ����д���������ڿ��ƶ���̶߳Ի���Ķ�ȡ
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	// ��ÿ��Ҫȡ��ֵ��Ϊ

	public Object getCache(int key) {
		Object value = null;
		rwl.readLock().lock();// ��ÿ����ȡ���ݵ��߳��϶���

		try {
			value = cache.get(key);
			if (value == null)// ��������û������ʱ��������һ���߳�ȥ���ݿ���ȡ���ݣ�Ȼ�󱣴��ڻ�����
			{
				// ���̵߳Ķ�������������ÿ���̶߳��������������������Ϊ���ú���������߳���ѡ��һ��������д��
				// ����ȥ���ݿ���ȡ���ݡ�
				// ��Ϊֻ�е������߳��ͷ��˶����󣬲������߳�����д��
				rwl.readLock().unlock();

				// �Ե�һ��ִ�����������߳�����д����������������ûִ�������������߳̾�ֻ�ܵȴ�ȥȡ���ݵ��߳�ȡ����ִ���������
				rwl.writeLock().lock();

				try {
					if (value == null)// ����ж������Ϊ���ڵ�һ�������ݿ���ȡ�����ݵ��߳�ִ����󣬷�ֹ�����߳��ظ�ȥ���ݿ���ȡ����
					{
						value = new Random().nextInt(10000);// ��������ʵ���Ǵ����ݿ���ȡ����
						System.out
								.println("�߳�"
										+ Thread.currentThread().getName()
										+ "�����ݿ���ȡ����");
						cache.put(key, value);// ��ȡ�������ݷŵ��������У���ʱvalue�ѱ���ֵ�������ȴ����̻߳���ǰ����ж�����ж�
					}
				} finally {
					// ���Զ��Ѿ�����д�����߳��϶�������������̳߳��е�����������,�������Է�ֹ�����߳�����
					// ���������ȥ���ݿ�ȥ�����Ǹ��߳�ִ�еĻ����ͻὫ������Ϊ������Ȼ�������߳�������ǰ�涼����д��������ȴ���ǰ�̰߳����ͷ�
					rwl.readLock().lock();
					rwl.writeLock().unlock();
				}
			} else
				System.out.println("������������2");
		} finally {

			rwl.readLock().unlock();
		}
		return value;
	}
}
