package �������̳߳���;

public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new MyThread("�߳�t1");
		Thread t2 = new MyThread("�߳�t2");
		t2.start();// ���ô�Thread��̳�������start()��������ʼһ���̣߳����̻߳�ȵ�ǰ���Ѵ������߳�ִ����Ϻ�ʼ
		System.out.println("���");// ���������t2.start()֮ǰִ�У���Ϊ������������̣߳�Ҫ��ִ�������߳��ϵ����ŻῪʼִ�д������߳��ϵ����
		t1.start();// ��������t2.start()֮��ִ�У���Ϊ���̱߳�t2.start()�̺߳󴴽������ȼ�����Ҫ��
	}

}

class MyThread extends Thread// Ҫ�������߳̿���ͨ��ʵ��Thread�࣬ͬʱҪʵ����run()����
{
	public MyThread(String name) {
		this.setName(name);
	}

	@Override
	public void run()// run()�����а��������߳���Ҫִ�е���䡣
	{
		System.out.println("�����߳�" + getName() + " �ҵ�id��" + getId() + " �������е��߳�id��" + Thread.currentThread().getId());
	}
}
