package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookProxy implements InvocationHandler {

	// 使用这个参数用来存放被代理的对象
	private Object target;

	/**
	 * 调用此方法对要存放的代理对象进行初始化，同时返回得到的代理对象
	 * 
	 * @param target
	 *            要被代理的对象
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	// 代理对象通过此方法来调用指定的被代理的对象某个方法来执行，同时完成方法的增强
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("==========前置通知==========");
		result = method.invoke(target, args);
		System.out.println("==========后置通知=========");
		return result;
	}

}
