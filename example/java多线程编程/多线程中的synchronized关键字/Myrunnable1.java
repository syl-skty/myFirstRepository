package 多线程中的synchronized关键字;

/**
 * 创建一个Runnable的实现类Myrunnable1
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
