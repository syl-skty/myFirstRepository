package ��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookProxy implements InvocationHandler {

	// ʹ���������������ű�����Ķ���
	private Object target;

	/**
	 * ���ô˷�����Ҫ��ŵĴ��������г�ʼ����ͬʱ���صõ��Ĵ������
	 * 
	 * @param target
	 *            Ҫ������Ķ���
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	// �������ͨ���˷���������ָ���ı�����Ķ���ĳ��������ִ�У�ͬʱ��ɷ�������ǿ
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("==========ǰ��֪ͨ==========");
		result = method.invoke(target, args);
		System.out.println("==========����֪ͨ=========");
		return result;
	}

}
