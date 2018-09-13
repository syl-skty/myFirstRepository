package ��̬����;

/**
 * ������ͱ������඼Ҫʵ��ͬһ���ӿڣ����ʹ�ñ�������ʹ�����ķ����Ϳ�������ͬ�ķ�������ЩҪ������ķ�����
 * 
 * @author skty
 *
 */
public class CountProxy implements Count {
	private CountImp imp;// ����һ��Ҫ��������Ķ������ԣ������ڴ���ʱ��ʹ���������������Ҫ����ǿ�ķ���

	public CountProxy(CountImp countImp) // ͨ�����췽������һ��Ҫ���������Ķ�����
	{
		imp = countImp;
	}

	@Override
	public void queryCount() {
		System.out.println("=============��ǿ����ǰ��Ĵ���==========");
		imp.queryCount();// ����Ҫ����ǿ�ķ���
		System.out.println("=============��ǿ��������Ĵ���==========");
	}

	@Override
	public void updateCount() {
		System.out.println("=============��ǿ����ǰ��Ĵ���==========");
		imp.updateCount();
		System.out.println("=============��ǿ��������Ĵ���==========");
	}

}
