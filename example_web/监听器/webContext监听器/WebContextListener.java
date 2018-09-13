package webContext������;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * web�����ļ������� ʹ��������������Լ���web�����ĳ�ʼ��������
 * 
 * ��Ҳ����webӦ�õ�������������ֻ��ʼ��һ�Σ���webӦ�õ�ֹͣ�����١�
 * 
 * @author skty
 *
 */
public class WebContextListener implements ServletContextListener {

	/**
	 * ���������web��������ǰ��ʱ����ã������ڴ˷�������ɶ���Դ��һЩ�ͷ�
	 */
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("======================web�������ڱ�����=======================");
	}

	/**
	 * ���������web������ʼ����ʱ����ã��ڴ˷�������������web��������ʱ����������ļ��Ķ����һЩ��Ҫ�Ķ���ĳ�ʼ��
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("======================web�������ڳ�ʼ��=======================");
		contextEvent.getServletContext().setAttribute("����Դ", "����Դ");
	}

}
