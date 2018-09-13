package 观察者设计模式.简单底层;

public class Test {

	public static void main(String[] args) {
		// 创建观察者和被观察者对象
		BeObserver be = new BeObserver();
		Observer ob = new Observer();
		// 被观察者中注册观察者对象，（实际就是对被观察者中的一个观察者属性对象进行赋值初始化）
		be.addObserver(ob);
		be.setData("数据1");
	}

}
