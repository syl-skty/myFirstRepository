package 静态常量与静态方法;

public class dog {
	static int age = 3;
	String name;

	public dog(String name) {
		this.name = name;
	}

	public static void show() {
		dog d1 = new dog("可乐");
		System.out.println("my name is " + d1.name);// 静态方法使用同类中的非静态变量时不能直接使用，必须创建对象来调用
		d1.cut();// 静态方法无法直接调用本类中的非静态方法。必须创建对象来调用
		System.out.println("my age is " + age);// 静态方法可以直接使用本类中的静态变量
		cut2();// 静态方法可以直接调用本类中的静态方法
		System.out.println("新建对象d1年龄static的值为：" + dog.age);
	}

	public void cut() {
		System.out
				.println("....................................................");
	}

	public static void cut2() {
		System.out
				.println("****************************************************");
	}
}
