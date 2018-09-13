package 读写锁的相关操作与使用;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通过读写锁的使用，当我们创建一个读写锁对象时，当我们有多个线程都在使用同一个读写锁对象时，一个线程对读写锁对象上读锁，可以允许其他
 * 对读写锁对象上读锁的线程一起执行，允许他们打断其运行，但不允许那些要对读写锁对象上写锁的线程运行。
 * 当一个线程对读写锁对象上了写锁，就不允许其他任何要对读写锁对象上读锁或写锁的线程运行，必须等待写锁释放后才能操作
 * 
 * 其实在java5线程中的读写锁并不是在上了读锁的时候必须去读数据，上了写锁的就必须去写数据，这只是一个对线程运行关系的表示
 * 表示一些线程运行时，可以允许一些线程一起运行，但不允许一些线程一起运行。这就引用了对数据的读写的规则来形容
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
	// 定义一个读写锁对象，当多个线程使用同一个读写锁时，才能有读写锁效果
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public void read() {
		rwl.readLock().lock();// 当前线程对读写锁对象上读锁，允许其他使用同一个读写锁对象上读锁的线程同步运行，但不允许上写锁的线程运行
		try {// 使用try语句，防止在出现异常时，无法释放当前读锁
			System.out.println("线程" + Thread.currentThread().getName()
					+ "开始读数据");
			System.out.println("线程" + Thread.currentThread().getName()
					+ "读完读数据");
		} finally {
			rwl.readLock().unlock();
		}
	}

	public void write() {
		rwl.writeLock().lock();// 当前线程对读写锁对象上写锁，此时不允许其他任何读写锁线程运行，必须等待
		try {
			System.out.println("线程" + Thread.currentThread().getName()
					+ "开始写数据");
			System.out.println("线程" + Thread.currentThread().getName()
					+ "写完读数据");
		} finally {
			rwl.writeLock().unlock();
		}
	}
}