package ���߳��е�synchronized�ؼ���;

/**
 * ����һ��Runnable��ʵ����Myrunnable1
 * 
 * @author skty
 * 
 */
public class Myrunnable1 implements Runnable {
	public Work w;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		w.show();
		w.say();

	}

}
