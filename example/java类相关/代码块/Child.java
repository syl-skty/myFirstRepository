package 代码块;

//子类
public class Child extends Father {
	public Child() {
		System.out.println("我是子类的构造方法>>正在执行");
	}

	{
		System.out.println("我是子类的非静态代码块>>正在执行");
	}
	static {
		System.out.println("我是子类的静态代码块>>正在执行");
	}
}
