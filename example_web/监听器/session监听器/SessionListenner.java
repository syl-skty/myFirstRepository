package session监听器;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器： 通过实现HttpSessionListener接口，可以创建一个监听器对象
 * 
 * 里面可以通过重写sessionCreated，sessionDestroyed方法来监听session的创建和销毁的过程
 * 
 * 每当创建一个session对象，就会调用sessionCreated方法，每当销毁一个session对象就会调用sessionDestroyed方法
 * 
 * @author skty
 *
 */
public class SessionListenner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("新创建了一个session对象");
		System.out.println("\t\tsessionid是：" + sessionEvent.getSession().getId());
		long t = sessionEvent.getSession().getLastAccessedTime();
		Date d = new Date(t);
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
		System.out.println("\t\t上次访问时间：" + format.format(d));
		sessionEvent.getSession().setMaxInactiveInterval(60);

		System.out.println("\t\t最长存活时间：" + sessionEvent.getSession().getMaxInactiveInterval());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("销毁一个session对象");
		System.out.println("\t\tsessionid是" + sessionEvent.getSession().getId());

	}

}
