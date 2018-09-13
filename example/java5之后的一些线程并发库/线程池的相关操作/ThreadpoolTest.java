package 线程池的相关操作;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 通过线程池，我们可以将许多的线程任务放入线程池中执行， 线程池首先会在任务线程中选择与线程池容量相同的线程加入就绪队列，其他的线程处于休眠状态，
 * 当已加入就绪队列的某个线程执行结束后，线程池会唤醒剩余的一个线程加入就绪队列，开始执行 这样一直反复加入，知道线程任务全部执行完成
 * 
 * @author skty
 * 
 */
public class ThreadpoolTest {
	public static void main(String[] args) {
		ThreadpoolTest t = new ThreadpoolTest();
		t.test();

	}

	public void test() {
		ExecutorService threadpool = Executors.newFixedThreadPool(1);// 创建一个固定线程容量为3的线程池
		// ExecutorService t = Executors.newCachedThreadPool();//
		// 创建一个缓存线程池，该线程池的大小是动态变化的，根据任务数量线程池大小自动调整
		// ExecutorService t = Executors.newSingleThreadExecutor();//
		// 创建单个线程的线程池，这里当单个线程死亡后，线程池会自动生成一个线程来执行
		for (int i = 0; i < 10; i++) // 使用for循环创建十个任务线程
		{
			final int k = i;
			threadpool.execute(new Runnable()// 将线程加入线程池的任务线程中，这里会加入10个线程任务，但由于线程池容量为3，所以每次就只能同时选择三个线程加入就绪队列
			{
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1; j <= 5; j++) {
						try {
							Thread.sleep(1000);
							System.out.println("我是线程" + k + "   这是我第" + j + "次执行");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			});
		}
		threadpool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("我是额外加入的线程");
			}
		});
		threadpool.shutdown();
	}

	public void test2() {
		ExecutorService t = Executors.newSingleThreadExecutor();// 创建单个线程的线程池，这里当单个线程死亡后，线程池会自动生成一个线程不是原来的线程来执行
		t.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 1; j <= 5; j++) {
					try {
						Thread.sleep(1000);
						System.out.println("我是单个线程 这是我第" + j + "次执行");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

	}

	public void test3() {
		ExecutorService t = Executors.newCachedThreadPool();// 创建一个缓存线程池，会根据线程任务的数目动态的分配线程池的容量
		for (int i = 0; i < 10; i++) // 使用for循环创建十个任务线程
		{
			final int k = i;
			t.execute(new Runnable()// 将线程加入线程池的任务线程中，这里会加入10个线程任务，但由于线程池容量为3，所以每次就只能同时选择三个线程加入就绪队列
			{
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1; j <= 5; j++) {
						try {
							Thread.sleep(1000);
							System.out.println("我是线程" + k + "   这是我第" + j + "次执行");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
		}
	}

	public void test4() {
		ScheduledExecutorService t = Executors.newScheduledThreadPool(3);// 设置一个定时器线程池，可在一定时间类自动调用线程池
		t.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("当前线程为" + Thread.currentThread().getName() + "时间为" + new Date().getSeconds());
			}
		}, 0, 1, TimeUnit.SECONDS);// 这里表示首次执行的时间延迟为0，之后每隔1秒启动一次线程池，TimeUnit.SECONDS表示时间单位为秒
	}

}
