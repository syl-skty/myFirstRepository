package ��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ʹ���ڲ���ķ�ʽ����һ����̬���������
 * 
 * 1.ʹ��Proxy.newProxyInstance(����������������,���������ʵ�ֵĽӿ�,���ɴ������Ĵ��������ӿڣ�ʹ���ڲ���ʵ�֣�)
 * 
 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[]
 * interfaces,InvocationHandler h)
 * 
 * 2.���Ϸ������ص�ֵ����һ��������Ķ�������Ҫʹ�ñ�������ʵ�ֵĽӿ����н��������ֵ(�����ñ����������н�)��
 * 
 * 3.InvocationHandler�ӿڵ��ڲ���Ҫʵ��һ��invoke(Object proxy, Method method, Object[]
 * args)��������������Ĳ�����ָ
 * 
 * proxy��ʵ�ִ���Ķ���
 * 
 * method��Ҫ����ķ���
 * 
 * args�������Ĳ���
 * 
 * 
 * @author skty
 *
 */
public class TestInnerClassProxy {

	public static void main(String[] args) {
		// ִ�о�̬������ȡһ���������(�ñ��������ʵ�ֵĽӿ����н�)
		Book bookProxy = (Book) Proxy.newProxyInstance(BookImp.class.getClassLoader(), BookImp.class.getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object result = null;// ������������ķ����ķ���ֵ(���ڽ�����Щ�з���ֵ�ķ���)
						System.out.println("=========ʹ���ڲ����ǰ��֪ͨ==========");

						result = method.invoke(new BookImp(), args);// ִ�б��������еķ���
						System.out.println("=========ʹ���ڲ���ĺ���֪ͨ==========");
						return result;
					}
				});
		// ����������ʹ��ǰ���ȡ���Ĵ�����������÷������������������������ʵ�ֽӿڵķ���������ǿ��
		bookProxy.deleteBook();
	}
}
