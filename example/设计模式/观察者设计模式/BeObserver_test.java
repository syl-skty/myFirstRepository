package �۲������ģʽ;

import java.util.Observable;

/**
 * ���۲��ߣ�
 * 
 * �̳�Observable�࣬��Ҫʹ�õ���Observable�������
 * 
 * addObserver(Observer o)����:����Ϊ������۲��߶�����ӹ۲��߶���
 * 
 * setChanged()�������������õ�ǰ���۲��ߵ�״̬�Ƿ�ı�
 * 
 * notifyObservers():����֪ͨ�۲��߶����õ�ǰ����Ĺ۲��ߵ���update��������
 * 
 * @author skty
 *
 */
public class BeObserver_test extends Observable {
	private Object data;

	// ����һ�����������ڹ۲��ߵ��������������ȡָ�������ݣ�
	// ��������������д���Ҫ���۲��ߵ�����
	public Object getData() {

		return data;
	}

	// ʹ���������ʱ���������������֪ͨ�۲��ߵĴ��룬���������ִ��ʱ���ͻᴥ���۲����е�update()����
	public void setDate(Object data) {
		System.out.println("���Ǳ��۲��ߣ����ڵ������֪ͨ�۲��ߵķ���");
		this.data = data;
		// ���ڱ�ʶ������۲�����Ѿ������˱仯��Observable������һ��changed��boolean������
		// ͨ�������������������Ϊtrue,���۲��ߵ���update����ǰ�ж����Ƿ�Ϊ��
		// �������ʹ����ͬ��������ʹ�ÿ����ڶ���߳�֮�����ù۲���ģʽ��
		this.setChanged();
		// ʹ�����������֪ͨ�۲��߶��󣬴˺�۲��߶���ͻ������update��������
		// notifyObservers(arg);����update������������һ������arg
		this.notifyObservers();
	}

}
