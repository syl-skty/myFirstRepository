package 观察者设计模式;

import java.util.Observable;

/**
 * 被观察者：
 * 
 * 继承Observable类，主要使用的是Observable类里面的
 * 
 * addObserver(Observer o)方法:用于为这个被观察者对象添加观察者对象
 * 
 * setChanged()方法：用于设置当前被观察者的状态是否改变
 * 
 * notifyObservers():用于通知观察者对象，让当前对象的观察者调用update（）方法
 * 
 * @author skty
 *
 */
public class BeObserver_test extends Observable {
	private Object data;

	// 创建一个方法，用于观察者调用这个方法来获取指定的数据，
	// 可以在这个方法中传递要给观察者的数据
	public Object getData() {

		return data;
	}

	// 使用这个方法时，由于里面加入了通知观察者的代码，当这个方法执行时，就会触发观察者中的update()方法
	public void setDate(Object data) {
		System.out.println("我是被观察者，正在调用添加通知观察者的方法");
		this.data = data;
		// 用于标识这个被观察对象已经发生了变化，Observable类中有一个changed（boolean）属性
		// 通过这个方法来将其设置为true,当观察者调用update方法前判断其是否为真
		// 这个方法使用了同步锁，这使得可以在多个线程之间设置观察者模式，
		this.setChanged();
		// 使用这个方法来通知观察者对象，此后观察者对象就会调用其update（）方法
		// notifyObservers(arg);调用update方法，并传递一个参数arg
		this.notifyObservers();
	}

}
