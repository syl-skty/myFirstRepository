package webContext监听器;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * web容器的监听器： 使用这个监听器可以监听web容器的初始化和销毁
 * 
 * 它也是随web应用的启动而启动，只初始化一次，随web应用的停止而销毁。
 * 
 * @author skty
 *
 */
public class WebContextListener implements ServletContextListener {

	/**
	 * 这个方法当web容器销毁前的时候调用，可以在此方法中完成对资源的一些释放
	 */
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("======================web容器正在被销毁=======================");
	}

	/**
	 * 这个方法在web容器初始化的时候调用，在此方法里，可以完成在web容器加载时，完成配置文件的读入和一些必要的对象的初始化
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("======================web容器正在初始化=======================");
		contextEvent.getServletContext().setAttribute("数据源", "数据源");
	}

}
