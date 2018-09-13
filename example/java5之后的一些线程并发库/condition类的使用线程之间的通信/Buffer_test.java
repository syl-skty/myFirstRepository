package condition类的使用线程之间的通信;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义的一个阻塞队列。 当使用Condition时，必须在Condition外面包一个lock.lock（）和lock.unlock()来获取对象的锁，
 * 不然会报异常 java.lang.IllegalMonitorStateException
 * 1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法; 2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
 * 3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法
 * 这表明Condition的内部是使用Object的wait()和notify()方法来实现的
 * 
 * 两组线程，一组线程负责对一个数组写入数据，另一组线程负责对同一个数组读出数据。而数组的长度小于两组线程的任意一个的数量 这里使用阻塞线程队列来实现：
 * 当写入进程写入数据后，从读出数据的阻塞队列中唤醒一个读出数据线程去读数据， 当读出进程读出数据后，从写入数据的阻塞队列中唤醒一个写入线程程去写数据
 * 数据数据满时，写入进程调用await()方法进入阻塞队列，同时此方法会从所有阻塞线程中选择一个线程执行，
 * 当数组为空时，读出进程调用await()方法进入阻塞队列，同时此方法会从所有阻塞线程中选择一个线程执行，
 * 
 * @author skty
 * 
 */
public class Buffer_test {
	public static void main(String[] args) {
		final buffer b = new buffer();
		for (int i = 0; i < 200; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						b.readData();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		for (int j = 0; j < 200; j++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						int data = new Random().nextInt(1000);
						b.writeData(data);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

	}
}

class buffer {
	private Object[] buffer = new Object[10];// 定义一个数组用于保存生成者和消费者的数据
	private int dataCount, takeptr, putptr = 0;// 定义以保存数据的数量，取数据的指针，放数据的指针
	Lock lock = new ReentrantLock();// 创建一个锁
	Condition read = lock.newCondition();// 定义一个存放不满足读数据条件时，存放那些不能执行的读数据操作时的线程的阻塞队列
	Condition write = lock.newCondition();// 定义一个存放不满足写数据条件时，存放那些不能执行写数据操作的线程的阻塞队列

	public Object readData() throws InterruptedException {
		lock.lock();// 在一个线程进行读数据操作时，防止其他线程也来读数据，所以将下面的代码加锁
		try {
			while (dataCount == 0)
				// 使用while语句，防止线程被假唤醒，多次判断
				// 当数组里面的数据为空时，无法读数据，将当前线程放入读条件不满足的阻塞队列，同时这里会去唤醒进程中的其他线程，包括读和写线程
				read.await();
			Object x = buffer[takeptr];// 有数据时，从数组中去对应指针的数据

			if (++takeptr == buffer.length) {// 当读指针读之前指向的是最后一个位置时，将下一次的指针指向第一个位置
				takeptr = 0;
			}
			--dataCount;// 数据的个数减一
			System.out.println("读取数据" + x + "  当前总量为：" + dataCount);
			write.signal();// 同时给要写线程的阻塞队列发信号，从写线程的阻塞队列唤醒一个线程，执行写数据
			return x;
		} finally {
			lock.unlock();// 将锁释放，让下一个要读数据的线程执行
		}
	}

	public void writeData(Object data) throws InterruptedException {
		lock.lock();// 在一个线程进行写数据操作时，防止其他线程也来写数据，所以将下面的代码加锁
		try {
			while (dataCount == buffer.length)
				// 使用while语句，防止线程被假唤醒，多次判断
				// 当数组中已经存满数据后，将当前写数据的线程放入，写线程的阻塞队列
				write.await();
			buffer[putptr] = data;// 将数据存储到写指针对应的位置

			if (++putptr == buffer.length)// 当上一次写指针指向的是最后一个位置时，将下一次要写的位置置为数组开头
			{
				putptr = 0;
			}
			++dataCount;// 数据数量加一
			System.out.println("写入数据" + data + "  当前总量为：" + dataCount);
			read.signal();// 写完数据后，发信号给那些由于没数据读而被阻塞在读数据阻塞队列的线程，唤醒其中的一个线程
		} finally {
			lock.unlock();// 当前线程释放锁，让下一个写数据的线程来执行
		}
	}
}
