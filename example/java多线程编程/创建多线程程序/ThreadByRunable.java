package �������̳߳���;

public class ThreadByRunable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Myrunnable(), "t1");
		Thread t2 = new Thread(new Myrunnable(), "t2");
		t1.start();// ����start()������ʼ�����̣߳��ȴ����߳�ִ�����ʼִ��
		t2.start();
		System.out.println("�������߳��ϵĴ���");

	}
}

// ����ͨ��ʵ��Runnable�ӿڣ�Ȼ��ʹ��Thread���Thread t=new Thread(Runnable����, �߳���)�������߳�
class Myrunnable implements Runnable {

	@Override
	public void run()// ������дrun()��������������߳�Ҫִ�е����
	{
		// TODO Auto-generated method stub
		System.out.println("��ǰ����id" + Thread.currentThread().getId());
	}

}