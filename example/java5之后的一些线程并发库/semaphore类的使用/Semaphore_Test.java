package semaphore类的使用;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * semaphore类表示Java中的信号灯机制，当一个semaphore对象设置了共同执行的个数（也就是总灯数），
 * 就是控制了当前访问资源的个数，同时执行线程的个数(总灯数)
 * 例如：当我们设置同时执行线程的个数为3，当有5个线程要执行时，首先会让3个线程先运行，剩余两个阻塞，当有一个线程执行完成后，就会从阻塞队列挑出一个来替补
 * 
 * @author skty
 * 
 */
public class Semaphore_Test {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);// 创建一个信号灯对象，并设置其灯数为三，也就是同时运行的个数为三
		for (int i = 0; i < 9; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();// 当前线程获取一盏灯，当灯全部被取完时，就在次等待，一旦有灯时就会被唤醒
						System.out.println("当前线程"
								+ Thread.currentThread().getName()
								+ "已获取一盏灯,剩余灯数为："
								+ (3 - semaphore.availablePermits()));
						Thread.sleep(new Random().nextInt(10000));
						semaphore.release();// 当前线程释放所获取的灯，同时唤醒阻塞队列中的一个线程
						System.out.println("当前线程"
								+ Thread.currentThread().getName()
								+ "已归还盏灯,剩余灯数为："
								+ (semaphore.availablePermits()));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
