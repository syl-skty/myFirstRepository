package java�еļ�ʱ��Timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUtil {
	public static void main(String[] args) {
		TimerUtil t = new TimerUtil();
		t.getSecond2();
	}

	public void sing() {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		}, 1000, 1000);
	}

	/**
	 * �˷���ͨ������һ����ʱ�Զ����õĶ�ʱ��,���Զ���������
	 */
	public void getSecond() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Calendar ca = Calendar.getInstance();
				System.out.println("���ڵ�ʱ����:" + ca.get(Calendar.YEAR) + "��" + (ca.get(Calendar.MONTH) + 1) + "��"
						+ ca.get(Calendar.DAY_OF_MONTH) + "��" + ca.get(Calendar.HOUR_OF_DAY) + "ʱ"
						+ ca.get(Calendar.MINUTE) + "��" + ca.get(Calendar.SECOND) + "��");
			}
		}, 0, 1000);
		Timer timer = new Timer();

	}

	/**
	 * ���ַ�ʽ�������ڴ�����һ���ӳ�ִ�еĶ�ʱ�������ᷴ�����ã��󣬵������ʱ��ִ����󣬻��Զ�����һ����ʱ����������һ�Σ�
	 * ������һ���ֻᴴ��һ��һ����ʱ�� �����ǵĶ�ʱ��ȥ������һ��ִ�еļ�ʱ������˷���
	 */
	public void getSecond2() {
		// �������Ǵ���һ����ʵ�ֳ����࣬�����Զ���һ��TimerTask����
		class Mytask extends TimerTask {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Calendar ca = Calendar.getInstance();
				System.out.println("���ڵ�ʱ����:" + ca.get(Calendar.YEAR) + "��" + (ca.get(Calendar.MONTH) + 1) + "��"
						+ ca.get(Calendar.DAY_OF_MONTH) + "��" + ca.get(Calendar.HOUR_OF_DAY) + "ʱ"
						+ ca.get(Calendar.MINUTE) + "��" + ca.get(Calendar.SECOND) + "��");
				// �ڴ�ӡʱ���ȥ����һ����ʱִ�еĶ�ʱ����׼����һ�ε�ִ�б�ʱ
				new Timer().schedule(new Mytask(), 1000);
			}
		}
		// ����һ���˶�ʱ���������������ǵĶ�ʱ��
		new Timer().schedule(new Mytask(), 1000);
	}
}
