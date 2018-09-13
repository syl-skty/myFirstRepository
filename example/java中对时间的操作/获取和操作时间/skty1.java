package 获取和操作时间;

import java.util.Calendar;

//Calendar类中包含了对时间处理的相关方法
public class skty1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lastsecond = 0;
		int i = 100;
		while (i > 0) {
			Calendar c = Calendar.getInstance();// Calendar类是抽象类，无法创建对象，必须其静态方法来使用其实现类创建对象
			int year = c.get(Calendar.YEAR);// 获取年份
			int month = c.get(Calendar.MONTH) + 1;// 获取月份，从0-11
			int day = c.get(Calendar.DAY_OF_MONTH);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			if (second % 1 == 0 && lastsecond != second) {
				System.out.println("现在是" + year + "年" + month + "月" + day + "日"
						+ hour + "时" + minute + "分" + second + "秒");

				lastsecond = second;
				i--;
			}
		}
		return;
	}
}
