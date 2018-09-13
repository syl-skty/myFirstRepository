package 创建多线程程序;

public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new MyThread("线程t1");
		Thread t2 = new MyThread("线程t2");
		t2.start();// 调用从Thread类继承下来的start()方法来开始一个线程，该线程会等到前面已创建的线程执行完毕后开始
		System.out.println("你好");// 这句语句会在t2.start()之前执行，因为该语句属于主线程，要先执行完主线程上的语句才会开始执行创建的线程上的语句
		t1.start();// 这语句会在t2.start()之后执行，因为该线程比t2.start()线程后创建，优先级比他要低
	}

}

class MyThread extends Thread// 要创建新线程可以通过实现Thread类，同时要实现其run()方法
{
	public MyThread(String name) {
		this.setName(name);
	}

	@Override
	public void run()// run()方法中包含的是线程中要执行的语句。
	{
		System.out.println("我是线程" + getName() + " 我的id是" + getId() + " 正在运行的线程id是" + Thread.currentThread().getId());
	}
}
