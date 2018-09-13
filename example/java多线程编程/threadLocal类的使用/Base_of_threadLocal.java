package threadLocal类的使用;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一些情况下，某些线程要对一个数据或对象进行操作，但是各个线程间又不能在对这个数据进行操作时不能被其他的线程对这个数据的操作干扰
 * 所以我们为每个线程都绑定一个这个要共同操作的数据，每个线程对这个数据的操作都相互独立，不会产生相互影响的情况
 * 典型的例子就是在对数据库进行操作时，每个事务都属于一个独立的线程
 * ，每个线程都有一个Connection对象，在事务操作时，每个事务对应的线程对应的Connection对象的操作都是独立的
 * 
 * 为了解决这种情况，为每个线程都绑定一个独立的变量或对象，java为我们提供了一个ThreadLocal对象，用于将当前线程与某一个对象绑定
 * 
 * ThreadLocal的底层实现就是使用一个Map对象
 * ，将当前线程作为键（key），要绑定的数据作为值(entry)，然后在调用put（）方法，将一条数据存储
 * ，在使用时，使用get()方法通过当前线程去map中查找已绑定的数据
 * 
 * @author skty
 * 
 */
// ThreadLoacal类的底层实现，
public class Base_of_threadLocal {

	private Map<Thread, Integer> map = new HashMap<Thread, Integer>();// 定义一个map来使当前线程和一个变量绑定
	private int shareDate;// 定义了一个共享变量，两个线程都会操作这个变量

	public static void main(String[] args) {
		Base_of_threadLocal b = new Base_of_threadLocal();
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
				map.put(Thread.currentThread(), data);// 将生成的变量与当前的线程绑定，这里不能绑定共享的变量，否则两个线程都绑定的是同一个变量，还是会相互干扰
				show(map.get(Thread.currentThread()));// 通过当前的线程去取与之绑定的变量
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
				map.put(Thread.currentThread(), data);
				show(map.get(Thread.currentThread()));
			}
		}).start();
	}

	public void show(int i) {
		System.out.println("当前线程为" + Thread.currentThread().getName() + "数据为："
				+ i);
	}
}
