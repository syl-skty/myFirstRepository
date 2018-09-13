package 自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 获取指定实体类对象的方法和属性上面的注解的值的方式：
 * 
 * 1.先获取实体类的类类型对象
 * 
 * 2.使用类类型对象去获取当前实体类中的所有方法和属性
 * 3.对那些有注解的方法和属性使用(getAnnotation（）)方法获取在其上面的注解对象（每个属性或方法上的一个注解都是一个自定义注解类的对象实例）
 * 4.获取到注解对象后调用对应属性的对应方法，就可以获取当前注解对象的各个属性值了。（然后就可以使用注解中的一些属性值来进行一些必要的操作了）
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
				System.out.print("==========方法:" + methodName + "(");
				for (Parameter parameter : parameters) {
					System.out.print(parameter.getType().getSimpleName() + " ");
				}
				System.out.println(")===========\n注解：");
				Annotation a2 = constructor.getAnnotation(a);// 获取到指定实体类的对象的类类型后，再获取其方法对应的对象，然后使用（方法对象.getAnnotation()）来获取在其上方的注解对象
				tool(a2);
			}
		}
	}

	public static void declaredFieldsAnnotation(Field[] fields, Class<? extends Annotation> a) throws Exception {
		for (Field field : fields) {
			if (field.isAnnotationPresent(a)) {
				System.out.println("==========属性" + field.getName() + "============\n注解:");
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
