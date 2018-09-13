package this关键字;

public class Test {
	public String a = "兄弟";

	public void sayHello() {
		System.out.println("hello!");
	}

	public void show() {
		// this关键字可表示当前调用该方法的对象，可以通过此对象来调用其属性和方法
		this.sayHello();
		System.out.println("你好" + this.a);
	}

}
