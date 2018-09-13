package java5中线程的lock;

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
	private Lock lock = new ReentrantLock();// 定义一把锁，当后面加锁时，相当于对这个对象加锁

	public void say() {
		lock.lock();// 调用lock()方法，在当前线程上给lock对象加锁，这样其他线程就不能在当前线程执行下面代码时打断当前线程的执行
		try {// 使用try语句防止在当前线程执行下面代码块时出现异常，导致无法释放当前锁
			for (int i = 0; i < 100; i++) {
				System.out.println("我是线程" + Thread.currentThread().getName() + "在执行say()方法");
			}
		} finally {
			lock.unlock();
		}
	}

	public void talk() {
		lock.lock();
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println("我是线程" + Thread.currentThread().getName() + "在执行talk()方法");
			}
		} finally {
			lock.unlock();
		}
	}

}
