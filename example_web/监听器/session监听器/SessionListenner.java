package session������;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session�������� ͨ��ʵ��HttpSessionListener�ӿڣ����Դ���һ������������
 * 
 * �������ͨ����дsessionCreated��sessionDestroyed����������session�Ĵ��������ٵĹ���
 * 
 * ÿ������һ��session���󣬾ͻ����sessionCreated������ÿ������һ��session����ͻ����sessionDestroyed����
 * 
 * @author skty
 *
 */
public class SessionListenner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("�´�����һ��session����");
		System.out.println("\t\tsessionid�ǣ�" + sessionEvent.getSession().getId());
		long t = sessionEvent.getSession().getLastAccessedTime();
		Date d = new Date(t);
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd HH:mm:ss");
		System.out.println("\t\t�ϴη���ʱ�䣺" + format.format(d));
		sessionEvent.getSession().setMaxInactiveInterval(60);

		System.out.println("\t\t����ʱ�䣺" + sessionEvent.getSession().getMaxInactiveInterval());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("����һ��session����");
		System.out.println("\t\tsessionid��" + sessionEvent.getSession().getId());

	}

}
