package ��ȡ�Ͳ���ʱ��;

import java.util.Calendar;

//Calendar���а����˶�ʱ�䴦�����ط���
public class skty1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lastsecond = 0;
		int i = 100;
		while (i > 0) {
			Calendar c = Calendar.getInstance();// Calendar���ǳ����࣬�޷��������󣬱����侲̬������ʹ����ʵ���ഴ������
			int year = c.get(Calendar.YEAR);// ��ȡ���
			int month = c.get(Calendar.MONTH) + 1;// ��ȡ�·ݣ���0-11
			int day = c.get(Calendar.DAY_OF_MONTH);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			if (second % 1 == 0 && lastsecond != second) {
				System.out.println("������" + year + "��" + month + "��" + day + "��"
						+ hour + "ʱ" + minute + "��" + second + "��");

				lastsecond = second;
				i--;
			}
		}
		return;
	}
}
