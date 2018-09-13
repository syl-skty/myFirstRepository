package ������ʵ�ֽ����������;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ʹ��javaweb�еĹ�������ʵ�ַ�ֹ��������
 * 
 * ����һ������������Ҫ����ʵ��Filter�ӿڣ��ӿ��д���destroy()��doFilter()��init()����������Ҫ��д
 * 
 * �����������ʱ��ʹ�ù������������е��û������url��Ҫ�����˹������Ĺ��ˣ��ɽ��ù�������urlƥ���������Ϊ��/*��,����ʹ��/
 * 
 * 
 * @author skty
 *
 */
public class Character_Filter implements Filter {

	private String Enconding;// ����һ����������Ŵ�web.xml��ȡ���û����õı����ʽ

	/**
	 * ���������Ҫʵ��web����Ҫ���ٸù���������ǰ���ô˷����������ͷ���ռ�õ���Դ��һ���������ʹ�����������
	 */
	@Override
	public void destroy() {

	}

	/**
	 * �÷����ǹ������ĺ��ķ�����������ɹ������Ĺ��˲��������û�������ǰ������ָ��������urlʱ��web�����ͻὫ�û��������������������ø÷�����ɹ��˵Ĳ���
	 * 
	 * �÷�����FilterChain�������Խ�������doFilter(request,
	 * response)��������ʾͨ�����ˣ����û����󴫵ݸ���һ������������ָ��Ŀ����Դ
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ʹ����δ��룬��������Ϣ�еı���ת��Ϊָ���ĸ�ʽ���룬�����ں�̨�����ַ�����ʱ�Ͳ����������������
		request.setCharacterEncoding(Enconding);
		// ���úñ����Ϳ��Խ����󴫵���ȥ����ʾ����ͨ��
		chain.doFilter(request, response);
		System.out.println("�ַ�����������������");
	}

	/**
	 * ��������ڹ�������ʼ��ʱ���ã���ɹ������ĳ�ʼ��������������Ҫ�ù�������ȡ�����ļ���ʵ����ʱ�����ڴ˷�����д�϶�ȡ������Ϣ�Ĵ���
	 * ����������Դ�web.xml�ж�ȡ������Ϣ������Ϣ����ʵ����������������
	 * 
	 * ʹ�ò���FilterConfig�Ϳ��Զ�ȡweb.xml�����õĲ�������Ӧ�Ĳ���ֵ
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// ��web.xml�ж�ȡ�������õĲ���Econding��Ӧ�Ĳ���ֵ����web.xml����������Ҫת���ı����ʽ�������Ϳ���ͨ�����web.xml�ļ����޸ģ�������Ҫ�޸Ĵ��룩
		Enconding = config.getInitParameter("Enconding");

	}

}
