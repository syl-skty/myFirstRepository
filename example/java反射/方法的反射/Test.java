package 方法的反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		foo f = new foo();
		Class c = f.getClass();
		Method method = c.getMethod("print", String.class, int.class);// 获取指定的方法对象，getMethod(方法名称,可变长度的参数列表（此处为Class类型）)
		method.invoke(f, "你好", 2);// 调用invoke(指定对象,输入可变长度的参数列表).反向使用指定对象去调用方法。
	}
}

class foo {
	public void print(String a, int b) {
		System.out.println("我是foo类的print()方法,我有两个参数" + a + "," + b);
	}
}