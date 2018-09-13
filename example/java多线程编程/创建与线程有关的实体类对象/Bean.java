package �������߳��йص�ʵ�������;

public class Bean {
	private String name;
	private int age;
	private static ThreadLocal<Bean> map = new ThreadLocal<Bean>();// ����һ��ThreadLocal�������洢�뵱ǰ�߳���ص�ʵ�������

	private Bean() {
	}// �����캯��˽�л��������ⲿ��Ͳ���ֱ�Ӵ���������

	public static Bean getThreadInstance()// �ⲿ�����ͨ����̬��������ȡʵ�������
	{
		Bean instance = map.get();// ����ȥ�ӵ�ǰ�߳�ȥȡ�İ󶨵�ʵ������������ǰ��󶨹��ˣ��Ϳ���ֱ��ȡ��
		if (instance == null) {// ����ǰ�߳�δ��ʵ�������ʱ���͵���˽�еĹ��췽��������һ���µĶ���
			instance = new Bean();
			System.out.println("��ǰ�߳�" + Thread.currentThread().getName()
					+ "�ް󶨵�ʵ�������");
			map.set(instance);// ������󽫶���󶨵���ǰ�߳�
		} else {
			System.out.println("��ǰ�߳�" + Thread.currentThread().getName()
					+ "���а󶨵�ʵ�������");
		}
		return instance;
	}

}
