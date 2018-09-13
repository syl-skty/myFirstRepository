package 代码块;

//父类
public class Father {

	public Father() {
		System.out.println("我是父类的构造函数>>正在执行");
	}

	{// 非静态代码块
		String a = "你好,我是父类的非静态代码块>>正在执行";
		System.out.println(a);
	}
	static {// 静态代码块
		String a = "你好,我是父类的静态代码块>>正在执行";
		System.out.println(a);
	}
}
