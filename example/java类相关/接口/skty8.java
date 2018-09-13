package 接口;

//一个接口可以继承多个父接口
//一个类可以实现多个接口，这弥补了一个类只能继承一个父类的不足
public class skty8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 用法1:创建实现类对象用接口的引用承接，来实现接口
		duck dk = new smallDuck("小黄");
		dk.fly();
		new smallDuck("豆豆").say();// 这样直接创建对象，不承接，也可以直接调用函数

		// 用法2:采用匿名内部类的方式来实现接口
		bird b = new bird() {

			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("我使用匿名内部类的方式实现了walk()方法");
			}

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("我使用匿名内部类的方式实现了fly()方法");
			}

		};
		b.walk();// 在创建对象时直接实现接口中的方法，并调用

		// 也可用
		new animal() {
			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("实现了animal接口");
			}

		}.walk();
	}

}
