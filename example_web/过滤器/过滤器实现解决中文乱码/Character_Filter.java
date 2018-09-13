package 过滤器实现解决中文乱码;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 使用javaweb中的过滤器来实现防止中文乱码
 * 
 * 创建一个过滤器对象，要让其实现Filter接口，接口中存在destroy()，doFilter()，init()三个方法需要重写
 * 
 * 解决中文乱码时，使用过滤器，对所有的用户请求的url都要经过此过滤器的过滤，可将该过滤器的url匹配规则设置为“/*”,不能使用/
 * 
 * 
 * @author skty
 *
 */
public class Character_Filter implements Filter {

	private String Enconding;// 定义一个属性来存放从web.xml读取到用户配置的编码格式

	/**
	 * 这个方法主要实在web容器要销毁该过滤器对象前调用此方法，用于释放其占用的资源（一般情况很少使用这个方法）
	 */
	@Override
	public void destroy() {

	}

	/**
	 * 该方法是过滤器的核心方法，用于完成过滤器的过滤操作，当用户方法当前过滤器指定关联的url时，web容器就会将用户的请求拦截下来，调用该方法完成过滤的操作
	 * 
	 * 该方法的FilterChain参数可以将调用其doFilter(request,
	 * response)方法，表示通过过滤，将用户请求传递给下一个过滤器或则指向目标资源
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 使用这段代码，将请求信息中的编码转换为指定的格式编码，这样在后台进行字符处理时就不会出现中文乱码了
		request.setCharacterEncoding(Enconding);
		// 设置好编码后就可以将请求传递下去，表示过滤通过
		chain.doFilter(request, response);
		System.out.println("字符编码过滤器过滤完成");
	}

	/**
	 * 这个方法在过滤器初始化时调用，完成过滤器的初始化，当我们有需要让过滤器读取配置文件来实例化时，可在此方法中写上读取配置信息的代码
	 * 这个方法可以从web.xml中读取配置信息，将信息用于实例化过滤器的配置
	 * 
	 * 使用参数FilterConfig就可以读取web.xml中设置的参数名对应的参数值
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// 从web.xml中读取里面配置的参数Econding对应的参数值（在web.xml中配置我们要转换的编码格式，这样就可以通过需改web.xml文件来修改，而不需要修改代码）
		Enconding = config.getInitParameter("Enconding");

	}

}
