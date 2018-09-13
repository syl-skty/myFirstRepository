package 代码块;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 执行过程： 1.父类的静态代码块 2.子类的静态代码块 3.父类的非静态代码块 4.父类的构造函数 5.子类的非静态代码块
		 * 6.子类的构造方法
		 */
		Child child = new Child();
	}

}

// 你好,我是父类的静态代码块>>正在执行
// 我是子类的静态代码块>>正在执行
// 你好,我是父类的非静态代码块>>正在执行
// 我是父类的构造函数>>正在执行
// 我是子类的非静态代码块>>正在执行
// 我是子类的构造方法>>正在执行