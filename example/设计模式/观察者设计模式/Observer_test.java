package �۲������ģʽ;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲��� ʵ��Observer�ӿ�
 * 
 * ����Ҫ��дһ��update(Observable o, Object arg)������
 * 
 * Observable o:��ʾ���۲��ߵ�һ��ʵ������,�����۲���ʹ����notifyObservers�����󣬻�ѵ����������������ı��۲��߶��󴫵ݹ���
 * 
 * Object arg����ʾ���۲��߶��󴫵ݹ����Ĳ���
 * 
 * @author skty
 *
 */
public class Observer_test implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		BeObserver_test ob = (BeObserver_test) o;// �������ı��۲��߶���ת��Ϊ����ָ���ı��۲�������
		String data = (String) ob.getData();// ���ô��ݹ����ı��۲����еķ�������ȡ���۲����е����ݣ����Ի�ȡ��������е����й������Ժͷ�����
		System.out.println("�ӱ��۲�����л�ȡ�����ݣ�" + data);
	}

}
