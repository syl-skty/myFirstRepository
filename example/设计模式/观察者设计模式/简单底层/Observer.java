package �۲������ģʽ.�򵥵ײ�;

public class Observer implements Observer_interface {

	@Override
	public void update(BeObserver_class be) {
		BeObserver beo = (BeObserver) be;
		System.out.println("�����߼���������" + beo.getData());

	}

}
