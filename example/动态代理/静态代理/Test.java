package 静态代理;

/**
 * 使用静态代理：
 * 
 * 1.创建一个接口，让代理类和被代理的类都实现该接口，同时所有方法都在接口中定义（这是为了保证代理类与被代理类拥有相同的方法）
 * 
 * 2.在代理类中定义一个被代理类的对象属性，这是为了使用代理类时，可以通过这个对象执行被代理类中的实现方法
 * 
 * 3.在代理类中声明一个带参构造函数，用于初始化前面定义的被代理类的属性对象
 * 
 * 4.可以在代理类中的同名方法中先对每次调用方法前和后面进行处理，然后在中间通过定义的被代理类的属性对象来调用要实际执行的方法
 * 
 * @author skty
 *
 */
public class Test {

	public static void main(String[] args) {
		CountImp c = new CountImp();
		CountProxy proxy = new CountProxy(c);
		proxy.queryCount();
		proxy.updateCount();
	}

}
