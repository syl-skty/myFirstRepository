package �̳߳ص���ز���;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ͨ���̳߳أ����ǿ��Խ������߳���������̳߳���ִ�У� �̳߳����Ȼ��������߳���ѡ�����̳߳�������ͬ���̼߳���������У��������̴߳�������״̬��
 * ���Ѽ���������е�ĳ���߳�ִ�н������̳߳ػỽ��ʣ���һ���̼߳���������У���ʼִ�� ����һֱ�������룬֪���߳�����ȫ��ִ�����
 * 
 * @author skty
 * 
 */
public class ThreadpoolTest {
	public static void main(String[] args) {
		ThreadpoolTest t = new ThreadpoolTest();
		t.test();

	}

	public void test() {
		ExecutorService threadpool = Executors.newFixedThreadPool(1);// ����һ���̶��߳�����Ϊ3���̳߳�
		// ExecutorService t = Executors.newCachedThreadPool();//
		// ����һ�������̳߳أ����̳߳صĴ�С�Ƕ�̬�仯�ģ��������������̳߳ش�С�Զ�����
		// ExecutorService t = Executors.newSingleThreadExecutor();//
		// ���������̵߳��̳߳أ����ﵱ�����߳��������̳߳ػ��Զ�����һ���߳���ִ��
		for (int i = 0; i < 10; i++) // ʹ��forѭ������ʮ�������߳�
		{
			final int k = i;
			threadpool.execute(new Runnable()// ���̼߳����̳߳ص������߳��У���������10���߳����񣬵������̳߳�����Ϊ3������ÿ�ξ�ֻ��ͬʱѡ�������̼߳����������
			{
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1; j <= 5; j++) {
						try {
							Thread.sleep(1000);
							System.out.println("�����߳�" + k + "   �����ҵ�" + j + "��ִ��");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			});
		}
		threadpool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("���Ƕ��������߳�");
			}
		});
		threadpool.shutdown();
	}

	public void test2() {
		ExecutorService t = Executors.newSingleThreadExecutor();// ���������̵߳��̳߳أ����ﵱ�����߳��������̳߳ػ��Զ�����һ���̲߳���ԭ�����߳���ִ��
		t.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 1; j <= 5; j++) {
					try {
						Thread.sleep(1000);
						System.out.println("���ǵ����߳� �����ҵ�" + j + "��ִ��");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

	}

	public void test3() {
		ExecutorService t = Executors.newCachedThreadPool();// ����һ�������̳߳أ�������߳��������Ŀ��̬�ķ����̳߳ص�����
		for (int i = 0; i < 10; i++) // ʹ��forѭ������ʮ�������߳�
		{
			final int k = i;
			t.execute(new Runnable()// ���̼߳����̳߳ص������߳��У���������10���߳����񣬵������̳߳�����Ϊ3������ÿ�ξ�ֻ��ͬʱѡ�������̼߳����������
			{
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1; j <= 5; j++) {
						try {
							Thread.sleep(1000);
							System.out.println("�����߳�" + k + "   �����ҵ�" + j + "��ִ��");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			});
		}
	}

	public void test4() {
		ScheduledExecutorService t = Executors.newScheduledThreadPool(3);// ����һ����ʱ���̳߳أ�����һ��ʱ�����Զ������̳߳�
		t.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("��ǰ�߳�Ϊ" + Thread.currentThread().getName() + "ʱ��Ϊ" + new Date().getSeconds());
			}
		}, 0, 1, TimeUnit.SECONDS);// �����ʾ�״�ִ�е�ʱ���ӳ�Ϊ0��֮��ÿ��1������һ���̳߳أ�TimeUnit.SECONDS��ʾʱ�䵥λΪ��
	}

}
