package 观察者设计模式.简单底层;

/**
 * 定义一个接口，用来规范观察者对象中的update方法，每个实例化观察者对象的类中都要重写update方法
 * 
 * @author skty
 *
 */
public interface Observer_interface {
	// 这个update方法要求传入就是当前触发update的被观察者对象
	public void update(BeObserver_class be);
}
