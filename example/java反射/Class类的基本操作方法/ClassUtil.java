package Class��Ļ�����������;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ��������Ҫ����������������ȡ���Ӧ�����Ϣ ��������������
 * 
 * @author ʷ����
 * 
 */
public class ClassUtil {
	public static void getClassMsgByObj(Object o) {
		Class c = o.getClass();
		System.out.println("������Ķ����Ӧ�������Ϣ���£�������" + c.getName());
		getClassFieldsByObj(o);
		getClassConstruByObj(o);
		getClassMethodsByObj(o);
	}

	/**
	 * ��ȡ�����Ӧ������з�����Ϣ�ķ���
	 * 
	 * @param o
	 *            �����һ���������
	 */
	public static void getClassMethodsByObj(Object o) {
		Class c = o.getClass();// ͨ������Ķ�������ȡ���Ӧ��������Ͷ���
		Method[] methods = c.getDeclaredMethods();// ��ȡ���������ķ���
		System.out.println("================����===============");
		for (Method method : methods) // �������з���
		{
			String name = method.getName();// ��ȡ����������
			Class[] parammeters = method.getParameterTypes();// ��ȡ������Ӧ��������
			String returnType = method.getReturnType().getSimpleName();// ��ȡ����ֵ������,Ȼ���ȡ����������
			System.out.print("\t" + returnType + "  " + name + "(");
			for (int i = 0; i < parammeters.length; i++) {
				if (i < parammeters.length - 1)
					System.out.print(parammeters[i].getSimpleName() + ",");
				else
					System.out.print(parammeters[i].getSimpleName());
			}
			System.out.println(")");
		}
	}

	/**
	 * ��ȡһ�������Ӧ���������Ϣ
	 * 
	 * @param o
	 */
	public static void getClassFieldsByObj(Object o) {
		Class c = o.getClass();
		Field[] fields = c.getDeclaredFields();
		System.out.println("=========================����=======================");

		for (Field field : fields) {
			Class fieldType = field.getType();// ��ȡ���Զ����Ӧ�������ͣ��Ի�ȡ���Ե�����
			String fType = fieldType.getSimpleName();
			System.out.println("\t" + fType + "  " + field.getName() + ";");
		}
	}

	/**
	 * ��ȡһ�������Ӧ��Ĺ��췽����Ϣ
	 * 
	 * @param o
	 */
	public static void getClassConstruByObj(Object o) {
		Class c = o.getClass();
		System.out.println("===========���췽��================");
		Constructor[] Constructors = c.getConstructors();
		for (Constructor constructor : Constructors) {
			String name = constructor.getName();
			System.out.print("\t" + name + "(");
			Class[] parameterTypes = constructor.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i < parameterTypes.length - 1)
					System.out.print(parameterTypes[i].getSimpleName() + ",");
				else
					System.out.print(parameterTypes[i].getSimpleName());
			}
			System.out.println(")");
		}
	}
}
