package 读写锁的相关操作与使用;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自己设计的一个缓存器
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
	// 创建一个map对象，用于以键值对的方式，保存要缓存的数据
	private Map<Integer, Object> cache = new HashMap<Integer, Object>();
	// 创建一个读写锁对象，用于控制多个线程对缓存的读取
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	// 将每次要取的值作为

	public Object getCache(int key) {
		Object value = null;
		rwl.readLock().lock();// 给每个来取数据的线程上读锁

		try {
			value = cache.get(key);
			if (value == null)// 当缓存中没有数据时，必须让一个线程去数据库中取数据，然后保存在缓存中
			{
				// 将线程的读锁解锁，这里每个线程都会解锁读锁，这样做是为了让后面从所有线程中选出一个来加上写锁
				// 让他去数据库中取数据。
				// 因为只有当所有线程释放了读锁后，才能让线程上上写锁
				rwl.readLock().unlock();

				// 对第一个执行这条语句的线程上上写锁，这样，其他还没执行完这条语句的线程就只能等待去取数据的线程取完后才执行这条语句
				rwl.writeLock().lock();

				try {
					if (value == null)// 这个判断语句是为了在第一个从数据库中取完数据的线程执行完后，防止其他线程重复去数据库中取数据
					{
						value = new Random().nextInt(10000);// 这里在现实中是从数据库中取数据
						System.out
								.println("线程"
										+ Thread.currentThread().getName()
										+ "从数据库中取数据");
						cache.put(key, value);// 将取到的数据放到缓存区中，此时value已被赋值，其他等待的线程会在前面的判断语句判断
					}
				} finally {
					// 可以对已经持有写锁的线程上读锁，这样这个线程持有的锁将被降级,这样可以防止其他线程重入
					// 这里如过是去数据库去数据那个线程执行的话，就会将锁降级为读锁，然后其他线程由于在前面都上了写锁，必须等待当前线程把锁释放
					rwl.readLock().lock();
					rwl.writeLock().unlock();
				}
			} else
				System.out.println("缓存已有数据2");
		} finally {

			rwl.readLock().unlock();
		}
		return value;
	}
}
