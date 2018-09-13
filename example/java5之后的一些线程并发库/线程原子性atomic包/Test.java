package 线程原子性atomic包;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这里使用AtomicInteger类里面包装了一个整型变量，在通过类中的相应方法来操作里面的整型变量，达到了在一个线程对其进行操作时，
 * 其他变量只能等待的效果
 * 
 * @author skty
 * 
 */
public class Test {
	public AtomicInteger atomic = new AtomicInteger(100);

	public static void main(String[] args) {
		Test t = new Test();
		t.work();
	}

	public void work() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.print("当前线程为" + Thread.currentThread().getName() + "第" + i + "次进行操作");
					int a = atomic.addAndGet(5);
					System.out.println("  操作完成后数据为：" + a);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.print("当前线程为" + Thread.currentThread().getName() + "第" + i + "次进行操作");
					int a = atomic.decrementAndGet();
					System.out.println("  操作完成后数据为：" + a);
				}
			}
		}).start();
	}

}
