package threadLocal���ʹ��;

/**
 * һ��ThreadLocal����ֻ�ܽ�һ���߳���һ�������������а󶨣����ʹ��mapһ��(һ���߳�keyֻ�ܶ�Ӧһ��ֵ)
 * 
 * @author skty
 * 
 */
public class Use_of_ThreadLocal {
	private ThreadLocal<Integer> map = new ThreadLocal<Integer>();// ����һ��ThreadLocal������ײ�ʵ��Ҳ��һ��map,ֻ���ڲ���ʱ�����Ƿ�װ�˻�ȡ��ǰ�̵߳�һ���֣�������������ֻҪ����һ������
	private int shareDate;// ������һ����������������̶߳�������������

	public static void main(String[] args) {
		Use_of_ThreadLocal b = new Use_of_ThreadLocal();
		b.work();
	}

	public void work() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int data = (int) (Math.random() * 100);// ����һ�������
				shareDate = data;// �����ɵı�����ֵ���������
				System.out.println("�߳�" + Thread.currentThread().getName()
						+ "���ɵ������Ϊ" + data);
				map.set(data);// ����set����
								// �����ɵı����뵱ǰ���̰߳󶨣����ﲻ�ܰ󶨹���ı��������������̶߳��󶨵���ͬһ�����������ǻ��໥����
				show(map.get());// ����get���� ͨ����ǰ���߳�ȥȡ��֮�󶨵ı���
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int data = (int) (Math.random() * 100);
				shareDate = data;
				System.out.println("�߳�" + Thread.currentThread().getName()
						+ "���ɵ������Ϊ" + data);
				map.set(data);
				show(map.get());
			}
		}).start();
	}

	public void show(int i) {
		System.out.println("��ǰ�߳�Ϊ" + Thread.currentThread().getName() + "����Ϊ��"
				+ i);
	}
}
