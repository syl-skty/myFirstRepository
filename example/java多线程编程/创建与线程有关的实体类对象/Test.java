package �������߳��йص�ʵ�������;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bean b = Bean.getThreadInstance();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Bean b2 = Bean.getThreadInstance();
			}
		}).start();
		Bean b3 = Bean.getThreadInstance();
	}

}
