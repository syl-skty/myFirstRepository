package java中的wait方法;

/**
 * wait()方法属于Object类中的方法，该方法能让当前持有对象锁的线程进入阻塞队列，同时会释放其持有的对象锁，
 * cpu会从就绪队列自动选择一个依靠该对象锁的线程来执行 通过notify()方法，可以唤醒一个要依靠此对象锁的另一个进程，让其加入就绪队列
 * 
 * wait方法通常使用多个线程共享的对象来调用，比如这里共享的是一个Test对象，可以使用this.wait()，this表示的就是共享的对象
 * 同时，notify方法也要使用多个线程共享的对象来调用(共享的对象.notify（）)。
 * 
 * @author skty
 * 
 */
public class Test {
	public boolean is_son_run = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Test t = new Test();
		// 创建并开始一个线程用于执行子程序
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++)
					t.son();
			}
		}).start();
		// 创建并开始一个父线程用于执行父程序
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++)
					t.father();
			}
		}).start();
	}

	// 使用synchronized关键字为方法加上对象锁，当两个线程使用的是同一个Test对象时，只能有一个线程调用此方法，另一个线程无法打断其运行
	public synchronized void son() {
		while (!is_son_run) {
			try {
				// 当不是子线程执行的时刻时，使用wait()方法让执行子程序的线程阻塞，此后cpu会去调用依赖该Test对象的父程序所在线程去执行
				// 这里两个线程所共享的数据是同一个Test对象，因此对象锁为这个Test对象，用this关键字可以表示这个对象来调用wait()方法
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("当前线程为：" + Thread.currentThread().getName()
					+ "————>子程序正在运行！");
		}
		is_son_run = false;
		// 当子程序执行完成后，调用notify方法去唤醒父程序所在线程
		this.notify();
	}

	// 使用synchronized关键字为方法加上对象锁，当两个线程使用的是同一个Test对象时，只能有一个线程调用此方法，另一个线程无法打断其运行
	public synchronized void father() {
		while (is_son_run) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("当前线程为：" + Thread.currentThread().getName()
					+ "————>父程序正在运行！");
		}
		is_son_run = true;
		this.notify();
	}
}
