package �۲������ģʽ.�򵥵ײ�;

public class Test {

	public static void main(String[] args) {
		// �����۲��ߺͱ��۲��߶���
		BeObserver be = new BeObserver();
		Observer ob = new Observer();
		// ���۲�����ע��۲��߶��󣬣�ʵ�ʾ��ǶԱ��۲����е�һ���۲������Զ�����и�ֵ��ʼ����
		be.addObserver(ob);
		be.setData("����1");
	}

}
