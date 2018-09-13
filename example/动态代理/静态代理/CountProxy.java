package 静态代理;

/**
 * 代理类和被代理类都要实现同一个接口，这就使得被代理类和代理类的方法就可以有相同的方法（那些要被代理的方法）
 * 
 * @author skty
 *
 */
public class CountProxy implements Count {
	private CountImp imp;// 创建一个要被代理类的对象属性，用于在代理时，使用这个对象来调用要被增强的方法

	public CountProxy(CountImp countImp) // 通过构造方法来将一个要被代理的类的对象传入
	{
		imp = countImp;
	}

	@Override
	public void queryCount() {
		System.out.println("=============增强方法前面的处理==========");
		imp.queryCount();// 调用要被增强的方法
		System.out.println("=============增强方法后面的处理==========");
	}

	@Override
	public void updateCount() {
		System.out.println("=============增强方法前面的处理==========");
		imp.updateCount();
		System.out.println("=============增强方法后面的处理==========");
	}

}
