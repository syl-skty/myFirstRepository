package threadLocal���ʹ��;

import java.util.HashMap;
import java.util.Map;

/**
 * ��һЩ����£�ĳЩ�߳�Ҫ��һ�����ݻ������в��������Ǹ����̼߳��ֲ����ڶ�������ݽ��в���ʱ���ܱ��������̶߳�������ݵĲ�������
 * ��������Ϊÿ���̶߳���һ�����Ҫ��ͬ���������ݣ�ÿ���̶߳�������ݵĲ������໥��������������໥Ӱ������
 * ���͵����Ӿ����ڶ����ݿ���в���ʱ��ÿ����������һ���������߳�
 * ��ÿ���̶߳���һ��Connection�������������ʱ��ÿ�������Ӧ���̶߳�Ӧ��Connection����Ĳ������Ƕ�����
 * 
 * Ϊ�˽�����������Ϊÿ���̶߳���һ�������ı��������javaΪ�����ṩ��һ��ThreadLocal�������ڽ���ǰ�߳���ĳһ�������
 * 
 * ThreadLocal�ĵײ�ʵ�־���ʹ��һ��Map����
 * ������ǰ�߳���Ϊ����key����Ҫ�󶨵�������Ϊֵ(entry)��Ȼ���ڵ���put������������һ�����ݴ洢
 * ����ʹ��ʱ��ʹ��get()����ͨ����ǰ�߳�ȥmap�в����Ѱ󶨵�����
 * 
 * @author skty
 * 
 */
// ThreadLoacal��ĵײ�ʵ�֣�
public class Base_of_threadLocal {

	private Map<Thread, Integer> map = new HashMap<Thread, Integer>();// ����һ��map��ʹ��ǰ�̺߳�һ��������
	private int shareDate;// ������һ����������������̶߳�������������

	public static void main(String[] args) {
		Base_of_threadLocal b = new Base_of_threadLocal();
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
				map.put(Thread.currentThread(), data);// �����ɵı����뵱ǰ���̰߳󶨣����ﲻ�ܰ󶨹���ı��������������̶߳��󶨵���ͬһ�����������ǻ��໥����
				show(map.get(Thread.currentThread()));// ͨ����ǰ���߳�ȥȡ��֮�󶨵ı���
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
				map.put(Thread.currentThread(), data);
				show(map.get(Thread.currentThread()));
			}
		}).start();
	}

	public void show(int i) {
		System.out.println("��ǰ�߳�Ϊ" + Thread.currentThread().getName() + "����Ϊ��"
				+ i);
	}
}
