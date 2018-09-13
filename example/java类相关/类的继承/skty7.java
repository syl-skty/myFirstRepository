package 类的继承;

public class skty7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		animal a = new animal();
		animal a1 = new dog(3, "white");
		animal a2 = new cat();
		// 多态实例
		System.out.println("多态实例");
		a.show();// 调用animal 中的show()
		a1.show();// 调用dog中的show()
		a2.show();// 调用cat中得show()

		// 调用dog中重写得toString equals方法
		System.out.println("调用dog中重写得toString equals方法");
		System.out.println(a1);
		if (a1.equals(a2))
			System.out.println("dog类对象与此类对象不相同");

		// 类的转换
		System.out.println("类的转换");
		animal a3 = a1;// 子类可以直接转换为父类对象，只会把相同的属性接受，父类中没有的属性方法会被舍弃
		a3.show();// 此时的show()为子类对象中的show()，不是父类中的
		// dog d1=(dog)a;//父类转换为子类要使用强制类型转换，并且有风险报错

		if (a1 instanceof cat)// 用instanceof来判断两个类可不可以转换，如果可以返回true
		{
			a1 = a2;
		} else
			System.out.println("无法完成cat到dog的转换");

	}

}
