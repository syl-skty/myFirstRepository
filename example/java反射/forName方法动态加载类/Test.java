package forName方法动态加载类;

//Class.forName()方法不仅可以获得类的类类型，同时也可以动态加载一个类
//动态加载类在运行时需要这个类才加载这个类，在编译时不会加载
//静态加载类是编译时加载类，在编译时会加载这个类，如new 关键字创建对象时如果类不存在时通过不了编译
public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.helo");// 这个输入的类的全名不存在，但是不会在编译时报错，只会在运行时才报错
			// 因为动态加载类的方法可以实现在运行时加载，所以可以把功能性的类设置为动态加载类，这样在主程序编译好的情况下可以对某一个功能类的修改就实现了对整体功能的修改
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
