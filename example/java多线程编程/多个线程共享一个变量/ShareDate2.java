package 多个线程共享一个变量;

public class ShareDate2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Myrunnable());
		Thread t2 = new Thread(new Myrunnable());

		t1.start();
		t2.start();

	}

}

class Myrunnable implements Runnable {
	public static int shareDate = 100;// 当多个线程都要已相同的方式操作一个数据时，可以用一个类实现Runnable接口，然后在实现类中加一个属性来保存共享变量

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			synchronized (Myrunnable.class) {

				System.out.print("当前线程为" + Thread.currentThread().getName()
						+ " 操作前的数据为" + shareDate);
				shareDate--;
				System.out.println("当前线程为" + Thread.currentThread().getName()
						+ " 操作后的数据为" + shareDate);
			}
		}
	}

}