package �����ķ���;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		foo f = new foo();
		Class c = f.getClass();
		Method method = c.getMethod("print", String.class, int.class);// ��ȡָ���ķ�������getMethod(��������,�ɱ䳤�ȵĲ����б��˴�ΪClass���ͣ�)
		method.invoke(f, "���", 2);// ����invoke(ָ������,����ɱ䳤�ȵĲ����б�).����ʹ��ָ������ȥ���÷�����
	}
}

class foo {
	public void print(String a, int b) {
		System.out.println("����foo���print()����,������������" + a + "," + b);
	}
}