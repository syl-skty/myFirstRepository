package 观察者设计模式.简单底层;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个被观察对象的父类，当每个子类创建时，都会自动添加上父类中定义的方法与属性
 * 
 * @author skty
 *
 */
public class BeObserver_class {
	// 用一个list来存放所有被观察者对象中注册的观察者对象
	public List<Observer_interface> obs = new ArrayList<Observer_interface>();

	// 创建一个方法来用于给被观察者添加观察者
	public void addObserver(Observer_interface ob) {
		this.obs.add(ob);
	}

	// 删除观察者
	public void removeObserver(Observer_interface ob) {
		this.obs.remove(ob);
	}

	// 通知观察者，在子类中某个方法中调用这个方法就可以实现，在调用某个方法时，通知观察者调用其中的update方法
	public void notifyObservers() {
		for (Observer_interface observer : obs) {
			// 调用被观察者的update方法，并将当前观察者对象传递过去
			observer.update(this);
		}
	}
}
