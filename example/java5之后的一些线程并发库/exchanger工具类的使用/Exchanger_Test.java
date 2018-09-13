package exchanger工具类的使用;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Exchanger_Test {
	public static void main(String[] args) {
		// 创建一个Exchanger对象，并指明交换数据的类型为String
		final Exchanger<String> exchanger = new Exchanger<String>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "你好";
					Thread.sleep(new Random().nextInt(10000));
					System.out.println(Thread.currentThread().getName()
							+ "已到达交易地点");
					// 当第一个线程执行到此处时，如果发现在此之前没有其他线程执行到exchange（）方法，
					// 就被阻塞，等待下一个执行到exchange（）方法的线程，并与之交换数据
					String d = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()
							+ "交易完成，得到" + d);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "兄弟";
					Thread.sleep(new Random().nextInt(10000));
					System.out.println(Thread.currentThread().getName()
							+ "已到达交易地点");
					String d = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()
							+ "交易完成，得到" + d);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}
}
