package threadLocal类的使用;

/**
 * 一个ThreadLocal对象只能将一个线程与一个变量或对象进行绑定，这跟使用map一样(一个线程key只能对应一个值)
 * 
 * @author skty
 * 
 */
public class Use_of_ThreadLocal {
	private ThreadLocal<Integer> map = new ThreadLocal<Integer>();// 创建一个ThreadLocal对象，其底层实现也是一个map,只是在操作时帮我们封装了获取当前线程的一部分，所以这里我们只要输入一个泛型
	private int shareDate;// 定义了一个共享变量，两个线程都会操作这个变量

	public static void main(String[] args) {
		Use_of_ThreadLocal b = new Use_of_ThreadLocal();
		b.work();
	}

	public void work() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int data = (int) (Math.random() * 100);// 生成一个随机数
				shareDate = data;// 将生成的变量赋值给共享变量
				System.out.println("线程" + Thread.currentThread().getName()
						+ "生成的随机数为" + data);
				map.set(data);// 采用set方法
								// 将生成的变量与当前的线程绑定，这里不能绑定共享的变量，否则两个线程都绑定的是同一个变量，还是会相互干扰
				show(map.get());// 采用get方法 通过当前的线程去取与之绑定的变量
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int data = (int) (Math.random() * 100);
				shareDate = data;
				System.out.println("线程" + Thread.currentThread().getName()
						+ "生成的随机数为" + data);
				map.set(data);
				show(map.get());
			}
		}).start();
	}

	public void show(int i) {
		System.out.println("当前线程为" + Thread.currentThread().getName() + "数据为："
				+ i);
	}
}
