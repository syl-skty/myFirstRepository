package blockQueue阻塞队列;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue底层使用的是一个数组来存放队列中的数据，
 * 
 * 使用一个ReentrantLock对象来对阻塞队列中数据的存取进行控制，
 * 
 * 分别使用ReentrantLock对象创建两个Condition对象来分别放置读数据时的阻塞线程和存数据时的阻塞线程
 * 
 * 每次成功读出数据后，调用插入数据的阻塞队列中Condition对象中的signal()方法来对插入数据是阻塞队列进行唤醒，读取失败则将当前线程加入读数据的阻塞Condition对象中
 * 
 * 插入数据跟读取数据相似
 * 
 * 
 * @author skty
 *
 */
public class BlockQueueTest {

	// 创建一个数组式的阻塞队列，可以指定阻塞对列的容量，同时可以指定是否为公平的队列
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3, true);

	public static void main(String[] args) {
		final BlockQueueTest test = new BlockQueueTest();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					int value = new Random().nextInt(100);
					test.put(value);

				}
			}).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					test.get();
				}
			}).start();
		}
	}

	public void put(int value) {
		try {

			// 调用阻塞队列的put方法从队列中插入数据，如果队列满了，会让当前线程进入阻塞，当插入数据完成时，会去唤醒那些取数据的线程
			queue.put(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我是线程" + Thread.currentThread().getName() + "正在插入数据" + value + "到队列中");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int get() {

		int value = 0;
		try {

			// 从阻塞队列中取数据，当队列中无数据时，会进入阻塞，当成功取得数据时，会去唤醒那些要插入数据的线程
			value = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我是线程" + Thread.currentThread().getName() + "正在从队列中读取数据" + value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}

}
