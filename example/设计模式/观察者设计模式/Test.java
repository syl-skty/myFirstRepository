package �۲������ģʽ;

public class Test {

	public static void main(String[] args) {
		// �ֱ𴴽��۲��߶���ͱ��۲��߶���
		BeObserver_test be = new BeObserver_test();
		Observer_test ob = new Observer_test();
		// ���ñ��۲��߶����еķ�����Ϊ���۲������һ���۲��߶���
		be.addObserver(ob);
		// �����۲��ߵ�����ʹ����֪ͨ�۲��ߵķ���ʱ���ͻ��ڵ������������ͬʱ��Ҳ���ù۲����е�update��������
		be.setDate("����1");
	}

}
