package ���߳��е�synchronized�ؼ���;

public class Test_synchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Work w = new Work();
		Myrunnable1 r1 = new Myrunnable1();
		r1.w = w;
		Myrunnable2 r2 = new Myrunnable2();
		r2.w = w;
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++)
					System.out.println("��ã����������߳�");
			};
		}.start();
	}

}
