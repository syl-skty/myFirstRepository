package 观察者设计模式;

public class Test {

	public static void main(String[] args) {
		// 分别创建观察者对象和被观察者对象
		BeObserver_test be = new BeObserver_test();
		Observer_test ob = new Observer_test();
		// 调用被观察者对象中的方法，为被观察者添加一个观察者对象
		be.addObserver(ob);
		// 当被观察者调用了使用了通知观察者的方法时，就会在调用这个方法的同时，也调用观察者中的update（）方法
		be.setDate("数据1");
	}

}
