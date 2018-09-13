package �Զ���ע��;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * ��ȡָ��ʵ�������ķ��������������ע���ֵ�ķ�ʽ��
 * 
 * 1.�Ȼ�ȡʵ����������Ͷ���
 * 
 * 2.ʹ�������Ͷ���ȥ��ȡ��ǰʵ�����е����з���������
 * 3.����Щ��ע��ķ���������ʹ��(getAnnotation����)������ȡ���������ע�����ÿ�����Ի򷽷��ϵ�һ��ע�ⶼ��һ���Զ���ע����Ķ���ʵ����
 * 4.��ȡ��ע��������ö�Ӧ���ԵĶ�Ӧ�������Ϳ��Ի�ȡ��ǰע�����ĸ�������ֵ�ˡ���Ȼ��Ϳ���ʹ��ע���е�һЩ����ֵ������һЩ��Ҫ�Ĳ����ˣ�
 * 
 * @author skty
 *
 */
public class AnnotationUtil {
	public static void getAnnotation(Class<?> cls, Class<? extends Annotation> a) throws Exception {
		Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
		declaredMethodAnnotation(declaredConstructors, a);
		Method[] declaredMethods = cls.getDeclaredMethods();
		declaredMethodAnnotation(declaredMethods, a);
		Field[] declaredFields = cls.getDeclaredFields();
		declaredFieldsAnnotation(declaredFields, a);
	}

	public static void declaredMethodAnnotation(Executable[] de, Class<? extends Annotation> a) throws Exception {
		for (Executable constructor : de) {
			if (constructor.isAnnotationPresent(a)) {
				String methodName = constructor.getName().substring(constructor.getName().lastIndexOf(".") + 1);
				Parameter[] parameters = constructor.getParameters();
				System.out.print("==========����:" + methodName + "(");
				for (Parameter parameter : parameters) {
					System.out.print(parameter.getType().getSimpleName() + " ");
				}
				System.out.println(")===========\nע�⣺");
				Annotation a2 = constructor.getAnnotation(a);// ��ȡ��ָ��ʵ����Ķ���������ͺ��ٻ�ȡ�䷽����Ӧ�Ķ���Ȼ��ʹ�ã���������.getAnnotation()������ȡ�����Ϸ���ע�����
				tool(a2);
			}
		}
	}

	public static void declaredFieldsAnnotation(Field[] fields, Class<? extends Annotation> a) throws Exception {
		for (Field field : fields) {
			if (field.isAnnotationPresent(a)) {
				System.out.println("==========����" + field.getName() + "============\nע��:");
				Annotation a2 = field.getAnnotation(a);
				tool(a2);
			}
		}
	}

	public static void tool(Annotation a2) throws Exception {
		Method[] declaredMethods = a2.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			String name = method.getName();
			if (name.equals("equals") || name.equals("toString") || name.equals("hashCode")
					|| name.equals("annotationType"))
				continue;
			System.out.print(name + ":" + method.invoke(a2) + "\t");
		}
		System.out.println();
	}
}
