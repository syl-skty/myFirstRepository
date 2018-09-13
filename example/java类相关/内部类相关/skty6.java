package 内部类相关;

import 内部类相关.dog.sdog;

//外部类不能直接访问内部类的成员和方法
public class skty6 {
	int a = 3;
	static String b = "皮皮";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		skty6 s6 = new skty6();
		cat cat1 = s6.new cat();// 创建成员内部类的对象时必须先创建外部类的对象使用（内部类 内部类对象名=外部类对象.new
								// 内部类()）
		cat1.show();
		// 。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
		sdog s = new sdog();// 此处要import dog类中的sdog,不用外部类.new 创建,直接跟普通类一样创建
		s.show();
	}

	public void cut() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	public class cat// 成员内部类
	{
		String name;
		int age;

		public void show() {
			name = b;// 成员内部类可以直接访问外部类的属性和方法，但外部类不能访问内部类的数据
			age = a;
			cut();
			System.out.println("name:" + name + "   age:" + age);
		}

	}

}
