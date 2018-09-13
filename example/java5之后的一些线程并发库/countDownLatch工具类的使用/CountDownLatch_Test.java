package countDownLatch工具类的使用;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 该类的对象相当于一个计时器，当计时器计时为0时，所有被阻塞的线程将被同时唤醒并执行
 * 这里的计数使用的是，类中的countDown()方法，可以让计时器的记数减一
 * 
 * @author skty
 * 
 */
public class CountDownLatch_Test {

	public static void main(String[] args) {
		final CountDownLatch c1 = new CountDownLatch(1);// 定义一个CountDownLatch对象，并设置其计数为3
		final CountDownLatch c2 = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("线程"
								+ Thread.currentThread().getName()
								+ "已准备完毕，等待出发");
						c1.await();// 调用c1的await()方法，让这三个线程在此等待计时器归零后再启动
						Thread.sleep(new Random().nextInt(10000));
						System.out.println("线程"
								+ Thread.currentThread().getName() + "已到达");
						c2.countDown();// 调用countDown（）方法对c2的计数减一，当三个线程都执行到这里时，在c2出等待的所有线程被唤醒执行
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		try {
			Thread.sleep(1000);// 主线程睡眠一秒
			c1.countDown();// 调用c1的countDown()方法，让前面被阻塞的三个线程同时被唤醒执行
			c2.await();// 调用c2的await()方法，主线程等待计时为3的计时器归零后再执行
			System.out.println("所有线程执行完毕！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
