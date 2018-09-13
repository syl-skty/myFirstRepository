package java中的计时器Timer;

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
	 * 此方法通过定义一个延时自动调用的定时器,会自动反复调用
	 */
	public void getSecond() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Calendar ca = Calendar.getInstance();
				System.out.println("现在的时间是:" + ca.get(Calendar.YEAR) + "年" + (ca.get(Calendar.MONTH) + 1) + "月"
						+ ca.get(Calendar.DAY_OF_MONTH) + "日" + ca.get(Calendar.HOUR_OF_DAY) + "时"
						+ ca.get(Calendar.MINUTE) + "分" + ca.get(Calendar.SECOND) + "秒");
			}
		}, 0, 1000);
		Timer timer = new Timer();

	}

	/**
	 * 这种方式，我们在创建好一个延迟执行的定时器（不会反复调用）后，当这个定时器执行完后，会自动创建一个定时器，用于下一次，
	 * 接着下一次又会创建一个一个计时器 让我们的定时器去创建下一次执行的计时器，如此反复
	 */
	public void getSecond2() {
		// 这里我们创建一个类实现抽象类，用于自定义一个TimerTask对象
		class Mytask extends TimerTask {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Calendar ca = Calendar.getInstance();
				System.out.println("现在的时间是:" + ca.get(Calendar.YEAR) + "年" + (ca.get(Calendar.MONTH) + 1) + "月"
						+ ca.get(Calendar.DAY_OF_MONTH) + "日" + ca.get(Calendar.HOUR_OF_DAY) + "时"
						+ ca.get(Calendar.MINUTE) + "分" + ca.get(Calendar.SECOND) + "秒");
				// 在打印时间后，去创建一个定时执行的定时器，准备下一次的执行报时
				new Timer().schedule(new Mytask(), 1000);
			}
		}
		// 创建一个人定时器，用于启动我们的定时器
		new Timer().schedule(new Mytask(), 1000);
	}
}
