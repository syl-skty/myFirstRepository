package 抽象类;

//通过定义抽象类可以限制子类必须实现某些方法，不关注实现的细节.
//抽象类无法直接创建对象,但可以创建引用来承接子类的对象（实现类）
public abstract class Tv {
	int size;
	String type;

	public Tv() {

	}

	public abstract void open();// 在抽象类中定义抽象方法可以不用写函数体和花括号

	public void show() {
		System.out.println("这是台电视");
	}
}
