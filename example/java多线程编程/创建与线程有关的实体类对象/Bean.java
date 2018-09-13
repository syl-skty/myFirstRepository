package 创建与线程有关的实体类对象;

public class Bean {
	private String name;
	private int age;
	private static ThreadLocal<Bean> map = new ThreadLocal<Bean>();// 创建一个ThreadLocal对象来存储与当前线程相关的实体类对象

	private Bean() {
	}// 将构造函数私有化，这样外部类就不能直接创建对象了

	public static Bean getThreadInstance()// 外部类必须通过静态方法来获取实体类对象
	{
		Bean instance = map.get();// 尝试去从当前线程去取的绑定的实体类变量，如果前面绑定过了，就可以直接取到
		if (instance == null) {// 当当前线程未绑定实体类对象时，就调用私有的构造方法，创建一个新的对象
			instance = new Bean();
			System.out.println("当前线程" + Thread.currentThread().getName()
					+ "无绑定的实体类对象");
			map.set(instance);// 创建完后将对象绑定到当前线程
		} else {
			System.out.println("当前线程" + Thread.currentThread().getName()
					+ "已有绑定的实体类对象");
		}
		return instance;
	}

}
