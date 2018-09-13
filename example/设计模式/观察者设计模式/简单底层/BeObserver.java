package 观察者设计模式.简单底层;

public class BeObserver extends BeObserver_class {
	private Object data;

	/**
	 * 定义这个方法，用于给观察者通过这个方法来获取那些private protected修饰的变量
	 * 
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 在这个方法中调用被观察者继承下来的父类的notifyObservers()方法来使用其内置的一个已经注册的观察者来调用观察者的update（）方法
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		System.out.println("被观察者正在写入数据");
		this.data = data;
		// 调用这个从父类继承下来的方法，来使用被观察者中的观察者对象来调用update（）方法
		notifyObservers();
	}
}
