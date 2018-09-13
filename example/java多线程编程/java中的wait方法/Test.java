package java�е�wait����;

/**
 * wait()��������Object���еķ������÷������õ�ǰ���ж��������߳̽����������У�ͬʱ���ͷ�����еĶ�������
 * cpu��Ӿ��������Զ�ѡ��һ�������ö��������߳���ִ�� ͨ��notify()���������Ի���һ��Ҫ�����˶���������һ�����̣���������������
 * 
 * wait����ͨ��ʹ�ö���̹߳���Ķ��������ã��������ﹲ�����һ��Test���󣬿���ʹ��this.wait()��this��ʾ�ľ��ǹ���Ķ���
 * ͬʱ��notify����ҲҪʹ�ö���̹߳���Ķ���������(����Ķ���.notify����)��
 * 
 * @author skty
 * 
 */
public class Test {
	public boolean is_son_run = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Test t = new Test();
		// ��������ʼһ���߳�����ִ���ӳ���
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++)
					t.son();
			}
		}).start();
		// ��������ʼһ�����߳�����ִ�и�����
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++)
					t.father();
			}
		}).start();
	}

	// ʹ��synchronized�ؼ���Ϊ�������϶��������������߳�ʹ�õ���ͬһ��Test����ʱ��ֻ����һ���̵߳��ô˷�������һ���߳��޷����������
	public synchronized void son() {
		while (!is_son_run) {
			try {
				// ���������߳�ִ�е�ʱ��ʱ��ʹ��wait()������ִ���ӳ�����߳��������˺�cpu��ȥ����������Test����ĸ����������߳�ȥִ��
				// ���������߳��������������ͬһ��Test������˶�����Ϊ���Test������this�ؼ��ֿ��Ա�ʾ�������������wait()����
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("��ǰ�߳�Ϊ��" + Thread.currentThread().getName()
					+ "��������>�ӳ����������У�");
		}
		is_son_run = false;
		// ���ӳ���ִ����ɺ󣬵���notify����ȥ���Ѹ����������߳�
		this.notify();
	}

	// ʹ��synchronized�ؼ���Ϊ�������϶��������������߳�ʹ�õ���ͬһ��Test����ʱ��ֻ����һ���̵߳��ô˷�������һ���߳��޷����������
	public synchronized void father() {
		while (is_son_run) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("��ǰ�߳�Ϊ��" + Thread.currentThread().getName()
					+ "��������>�������������У�");
		}
		is_son_run = true;
		this.notify();
	}
}
