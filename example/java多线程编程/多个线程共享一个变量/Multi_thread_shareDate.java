package 多个线程共享一个变量;

//多个线程共享一个变量，多个线程在运行时要操作同一个变量，但允许线程之间的相互干扰。
//典型例子就是售票系统，票数在多个售票线程运行时共享
public class Multi_thread_shareDate {
	private static int shareDate = 100;// 在类里面定义一个共享的属性，每个线程都操作这个属性

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				plus();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				decrise();
			}
		}).start();
	}

	public static void plus() {// 由于是静态方法，所以加锁时使用的是类锁，使用.class进行对代码块加锁
		for (int i = 0; i < 5; i++) {
			synchronized (Multi_thread_shareDate.class) // 加synchronized关键字为这个加过程的代码块加锁，防止在一个线程进行加操作和打印操作时，被其他线程打断
			{
				System.out.print("共享数据加操作前的值为：" + shareDate);
				shareDate++;
				System.out.println("操作后为" + shareDate);
			}
		}
	}

	public static void decrise() {
		for (int i = 0; i < 5; i++) {
			synchronized (Multi_thread_shareDate.class) {
				System.out.print("共享数据减操作前的值为：" + shareDate);
				shareDate--;
				System.out.println("减操作后为" + shareDate);
			}

		}
	}

}
