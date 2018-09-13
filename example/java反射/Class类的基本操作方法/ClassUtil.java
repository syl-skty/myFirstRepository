package Class类的基本操作方法;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 此类中主要包含对于任意对象读取其对应类的信息 包括方法，属性
 * 
 * @author 史永龙
 * 
 */
public class ClassUtil {
	public static void getClassMsgByObj(Object o) {
		Class c = o.getClass();
		System.out.println("你输入的对象对应的类的信息如下：类名：" + c.getName());
		getClassFieldsByObj(o);
		getClassConstruByObj(o);
		getClassMethodsByObj(o);
	}

	/**
	 * 获取对象对应类的所有方法信息的方法
	 * 
	 * @param o
	 *            输入的一个任意对象
	 */
	public static void getClassMethodsByObj(Object o) {
		Class c = o.getClass();// 通过输入的对象来获取其对应类的类类型对象
		Method[] methods = c.getDeclaredMethods();// 获取所有声明的方法
		System.out.println("================方法===============");
		for (Method method : methods) // 遍历所有方法
		{
			String name = method.getName();// 获取方法的名称
			Class[] parammeters = method.getParameterTypes();// 获取参数对应的类类型
			String returnType = method.getReturnType().getSimpleName();// 获取返回值类类型,然后获取其类型名字
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
	 * 获取一个对象对应类的所有信息
	 * 
	 * @param o
	 */
	public static void getClassFieldsByObj(Object o) {
		Class c = o.getClass();
		Field[] fields = c.getDeclaredFields();
		System.out.println("=========================属性=======================");

		for (Field field : fields) {
			Class fieldType = field.getType();// 获取属性对象对应的类类型，以获取属性的类型
			String fType = fieldType.getSimpleName();
			System.out.println("\t" + fType + "  " + field.getName() + ";");
		}
	}

	/**
	 * 获取一个对象对应类的构造方法信息
	 * 
	 * @param o
	 */
	public static void getClassConstruByObj(Object o) {
		Class c = o.getClass();
		System.out.println("===========构造方法================");
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
