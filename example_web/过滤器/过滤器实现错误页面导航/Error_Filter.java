package ������ʵ�ִ���ҳ�浼��;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ��web.xml�����øù�����������ΪERROR���Ϳ������������ָ�����˵�urlƥ���µĳ��ִ����ҳ����й�����
 * ��ָ��ӳ���url����ҳ������ʱ�����øù������Ĺ��˷���
 * 
 * @author skty
 *
 */
public class Error_Filter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���ִ���ҳ��");
		// ������ɺ���Ҫ����doFilter��������Ȼ���ڴ�����
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
