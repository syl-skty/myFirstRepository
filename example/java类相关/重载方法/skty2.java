package 重载方法;

//重载方法：两个方法函数名一样，但参数类型不一样(与方法的修饰符和返回值类型无关)，执行的方式也不一样
public class skty2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		skty2.show(100);// show()方法为静态方法：调用时直接用类名.show()使用
		skty2.show("hello");
	}

	public static void show(int a) {
		System.out.println("我是一个整型变量" + a);
	}

	public static void show(String a) {
		System.out.println("我是一个字符型变量" + a);
	}

}
