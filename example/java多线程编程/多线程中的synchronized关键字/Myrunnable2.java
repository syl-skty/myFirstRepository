package 多线程中的synchronized关键字;

public class Myrunnable2 implements Runnable {
	public Work w;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		w.say();
		w.show();
	}

}
