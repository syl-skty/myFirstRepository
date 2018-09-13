package �۲������ģʽ.�򵥵ײ�;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����۲����ĸ��࣬��ÿ�����ഴ��ʱ�������Զ�����ϸ����ж���ķ���������
 * 
 * @author skty
 *
 */
public class BeObserver_class {
	// ��һ��list��������б��۲��߶�����ע��Ĺ۲��߶���
	public List<Observer_interface> obs = new ArrayList<Observer_interface>();

	// ����һ�����������ڸ����۲�����ӹ۲���
	public void addObserver(Observer_interface ob) {
		this.obs.add(ob);
	}

	// ɾ���۲���
	public void removeObserver(Observer_interface ob) {
		this.obs.remove(ob);
	}

	// ֪ͨ�۲��ߣ���������ĳ�������е�����������Ϳ���ʵ�֣��ڵ���ĳ������ʱ��֪ͨ�۲��ߵ������е�update����
	public void notifyObservers() {
		for (Observer_interface observer : obs) {
			// ���ñ��۲��ߵ�update������������ǰ�۲��߶��󴫵ݹ�ȥ
			observer.update(this);
		}
	}
}
