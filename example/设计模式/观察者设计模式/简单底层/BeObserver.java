package �۲������ģʽ.�򵥵ײ�;

public class BeObserver extends BeObserver_class {
	private Object data;

	/**
	 * ����������������ڸ��۲���ͨ�������������ȡ��Щprivate protected���εı���
	 * 
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * ����������е��ñ��۲��߼̳������ĸ����notifyObservers()������ʹ�������õ�һ���Ѿ�ע��Ĺ۲��������ù۲��ߵ�update��������
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		System.out.println("���۲�������д������");
		this.data = data;
		// ��������Ӹ���̳������ķ�������ʹ�ñ��۲����еĹ۲��߶���������update��������
		notifyObservers();
	}
}
