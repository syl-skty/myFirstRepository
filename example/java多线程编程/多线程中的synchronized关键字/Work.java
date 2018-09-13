package 多线程中的synchronized关键字;

/**
 * 为了实现在一个线程调用work其中的方法时，不能被操作Work中的方法其他线程线程打断；
 * 我们使用synchronized为多个线程要操作的相同部分进行加锁，
 * 这样加锁以后，当一个线程取得了各个线程都要操作的对象时，其他要操作这个对象的线程就只能等待当前已取得共有对象的线程执行完后才能取
 * 但其他不依靠公共对象的线程会打断当前线程，只有那些依靠公共对象的线程会等待
 * 
 * synchronized加锁有两种方式： 1.对多个线程的共同要使用的对象进行加锁
 * 2.对一个方法进行加锁，当一个线程在执行加锁的方法时，其他要调用该方法的线程必须等待
 * 
 * 对方法加锁时，有两种情况：1.对非静态方法加锁，这种情况当两个线程使用的是同一个对象来调用方法时，当一个线程持有对象锁时，另一个线程就不能执行该方法
 * 2.对静态方法加锁，这种情况当两个线程使用的是同一个类的两个不同或相同的对象来调用方法时，当一个线程持有当前类的类锁时，
 * 另一个要调用该方法的线程不管是不是同一个对象或者不同对象，都要等待
 * 
 * @author skty
 * 
 */
public class Work {
	public void show() {
		// 这里因为多个线程调用该方法时，使用的是不同的Work对象，所以只能对他们的公共部分加锁，也就是Work的字节码（类类型）加锁
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("当前进程为" + Thread.currentThread().getName()
						+ "执行show方法");
			}
		}

	}

	public void say() {
		// 这里因为多个线程调用该方法时，使用的是不同的Work对象，所以只能对他们的公共部分加锁，也就是Work的字节码（类类型）加锁
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("当前进程为" + Thread.currentThread().getName()
						+ "执行say方法");
			}
		}
	}

	/**
	 * 对非静态方法加锁(对象锁)，当两个线程使用的是同一个Work对象都要调用这个方法时，可以对这个方法加锁，
	 * 但当两个线程使用的是两个不同的Work对象时，对这个方法加锁，无法实现线程互斥。
	 */
	public synchronized void talk() {
		for (int i = 0; i < 5; i++) {
			System.out.println("当前进程为" + Thread.currentThread().getName()
					+ "执行talk方法");
		}
	}

	/**
	 * 对静态方法加锁(类锁)，当两个线程使用的是同一个类中的同一个对象或则不同对象时，都会给此方法加锁，不允许其他线程调用
	 */
	public synchronized static void walk() {
		for (int i = 0; i < 5; i++) {
			System.out.println("当前进程为" + Thread.currentThread().getName()
					+ "执行walk方法");
		}
	}

}
