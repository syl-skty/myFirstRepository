package 自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解使用无参的方法代表属性，有数据类型，对应的方法名就是属性的名字
 * 
 * 方法名就是属性名
 * 
 * 方法的返回值类型就是对应属性的数据类型
 * 
 * 可以有默认值，在方法后面使用default来声明
 * 
 * 
 * 
 * @author skty
 *
 */
// 用来描述自定义注解的生命周期，RetentionPolicy.RUNTIME:表示在运行时有效，ClASS：表示在class文件中有效，SOURCE表示在源文件中有效
@Retention(RetentionPolicy.RUNTIME)
// Target用于说明该注解可以在什么地方使用
// ElementType.CONSTRUCTOR ：可用于构造器 ElementType.FIELD:可用于属性
// ElementType.METHOD：可用于方法 （这些一般常用）
@Target({ ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface Fruit {
	String fruitColor() default "green";

	// 方法的名字就是对应的属性的名字，当获取了当前自定义注解类的对象时，可以使用（对象.方法名()）返回的就是当前注解对象的方法对应的属性值
	String fruitName();

	String fruitProvider();

}
