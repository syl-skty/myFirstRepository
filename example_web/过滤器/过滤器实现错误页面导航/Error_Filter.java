package 过滤器实现错误页面导航;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 在web.xml中配置该过滤器的类型为ERROR，就可以让其对在其指定过滤的url匹配下的出现错误的页面进行过滤了
 * 在指定映射的url出现页面错误的时候会调用该过滤器的过滤方法
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
		System.out.println("出现错误页面");
		// 过滤完成后还是要调用doFilter方法，不然会在此阻塞
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
