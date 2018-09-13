package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用内部类的方式创建一个动态代理类对象：
 * 
 * 1.使用Proxy.newProxyInstance(被代理类的类加载器,被代理类的实现的接口,生成代理对象的处理器（接口，使用内部类实现）)
 * 
 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[]
 * interfaces,InvocationHandler h)
 * 
 * 2.以上方法返回的值就是一个代理类的对象，我们要使用被代理类实现的接口来承接这个返回值(不能用被代理类来承接)。
 * 
 * 3.InvocationHandler接口的内部类要实现一个invoke(Object proxy, Method method, Object[]
 * args)方法，其中里面的参数是指
 * 
 * proxy：实现代理的对象
 * 
 * method：要代理的方法
 * 
 * args：方法的参数
 * 
 * 
 * @author skty
 *
 */
public class TestInnerClassProxy {

	public static void main(String[] args) {
		// 执行静态方法获取一个代理对象(用被代理类的实现的接口来承接)
		Book bookProxy = (Book) Proxy.newProxyInstance(BookImp.class.getClassLoader(), BookImp.class.getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object result = null;// 创建被代理类的方法的返回值(用于接收那些有返回值的方法)
						System.out.println("=========使用内部类的前置通知==========");

						result = method.invoke(new BookImp(), args);// 执行被代理类中的方法
						System.out.println("=========使用内部类的后置通知==========");
						return result;
					}
				});
		// 现在我们再使用前面获取到的代理对象来调用方法，这样，被代理类的所有实现接口的方法都被增强了
		bookProxy.deleteBook();
	}
}
