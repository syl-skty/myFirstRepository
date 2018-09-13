package 观察者设计模式;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 实现Observer接口
 * 
 * 里面要重写一个update(Observable o, Object arg)方法，
 * 
 * Observable o:表示被观察者的一个实例对象,当被观察者使用了notifyObservers方法后，会把调用这个方法的自身的被观察者对象传递过来
 * 
 * Object arg：表示被观察者对象传递过来的参数
 * 
 * @author skty
 *
 */
public class Observer_test implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		BeObserver_test ob = (BeObserver_test) o;// 将触发的被观察者对象转换为我们指定的被观察者类型
		String data = (String) ob.getData();// 调用传递过来的被观察者中的方法，获取被观察者中的数据（可以获取这个对象中的所有共有属性和方法）
		System.out.println("从被观察对象中获取的数据：" + data);
	}

}
