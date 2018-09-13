package �߳�ԭ����atomic��;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����ʹ��AtomicInteger�������װ��һ�����ͱ�������ͨ�����е���Ӧ������������������ͱ������ﵽ����һ���̶߳�����в���ʱ��
 * ��������ֻ�ܵȴ���Ч��
 * 
 * @author skty
 * 
 */
public class Test {
	public AtomicInteger atomic = new AtomicInteger(100);

	public static void main(String[] args) {
		Test t = new Test();
		t.work();
	}

	public void work() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.print("��ǰ�߳�Ϊ" + Thread.currentThread().getName() + "��" + i + "�ν��в���");
					int a = atomic.addAndGet(5);
					System.out.println("  ������ɺ�����Ϊ��" + a);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.print("��ǰ�߳�Ϊ" + Thread.currentThread().getName() + "��" + i + "�ν��в���");
					int a = atomic.decrementAndGet();
					System.out.println("  ������ɺ�����Ϊ��" + a);
				}
			}
		}).start();
	}

}
