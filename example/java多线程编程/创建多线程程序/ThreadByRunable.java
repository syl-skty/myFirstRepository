package 创建多线程程序;

public class ThreadByRunable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Myrunnable(), "t1");
		Thread t2 = new Thread(new Myrunnable(), "t2");
		t1.start();// 调用start()方法开始启动线程，等待主线程执行完后开始执行
		t2.start();
		System.out.println("我是主线程上的代码");

	}
}

// 可以通过实现Runnable接口，然后使用Thread类的Thread t=new Thread(Runnable对象, 线程名)来创建线程
class Myrunnable implements Runnable {

	@Override
	public void run()// 必须重写run()方法，里面包含线程要执行的语句
	{
		// TODO Auto-generated method stub
		System.out.println("当前进程id" + Thread.currentThread().getId());
	}

}