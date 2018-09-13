package Class类的相关认识;

/*
 * 所有类都是Class类的一个对象，每次创建一个类相当于创建了一个Class类的实例对象
 * 要获取一个类的类类型有三种方式：
 * 1: 类名.class方式获取，每个类类型的对象都有一个隐含的静态变量class
 * 2: 类对象.getClass()方法获取类对应的类类型
 * 3: Class.forName(类的全称) 通过Class类中的静态方法获取一个指定类全称的类类型
 */
public class TestClassType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c1 = foo.class;// 通过类名获取
		Class c2 = (new foo()).getClass();// 通过类对象获取类类型、

		try {
			Class c3 = Class.forName("Class类的相关认识.foo");// 通过Class.forName()获取
			System.out.println(c1 == c2);
			System.out.println(c2 == c3);// 三种方式 获取的类类型都是相同的
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class foo// 定义一个测试的类
{

}
