package 观察者设计模式.简单底层;

public class Observer implements Observer_interface {

	@Override
	public void update(BeObserver_class be) {
		BeObserver beo = (BeObserver) be;
		System.out.println("监听者监听到数据" + beo.getData());

	}

}
