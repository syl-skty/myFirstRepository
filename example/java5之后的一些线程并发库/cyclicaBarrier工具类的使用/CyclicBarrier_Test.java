package cyclicaBarrier工具类的使用;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier 类的作用是可以让多个线程在同一时刻集合，继续往前执行
 * 当cyclicBarrier对象设置的线程的数量为3时，当有一个线程先到达等待的代码时，
 * 会等待其他两个线程，当最后一个线程执行到等待的线程时，此时唤醒前两个先到的阻塞的线程，三个线程一起执行
 * 
 * @author skty
 * 
 */
public class CyclicBarrier_Test {
	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);// 创建一个CyclicBarrier对象，并设置其一起运行的线程为三个
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(new Random().nextInt(10000));
						System.out.println("当前线程为"
								+ Thread.currentThread().getName()
								+ "已经运行到集合点，等待的线程个数为"
								+ cyclicBarrier.getNumberWaiting());
						System.out
								.println(cyclicBarrier.getNumberWaiting() == 2 ? "集体出发"
										: "");
						cyclicBarrier.await();// 调用此方法可以让前面到的线程在此处阻塞，当所有线程都到时，唤醒所有线程，同时执行
						System.out.println("完成");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}

	}

}
