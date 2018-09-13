package �Զ���ע��;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע��ʹ���޲εķ����������ԣ����������ͣ���Ӧ�ķ������������Ե�����
 * 
 * ����������������
 * 
 * �����ķ���ֵ���;��Ƕ�Ӧ���Ե���������
 * 
 * ������Ĭ��ֵ���ڷ�������ʹ��default������
 * 
 * 
 * 
 * @author skty
 *
 */
// ���������Զ���ע����������ڣ�RetentionPolicy.RUNTIME:��ʾ������ʱ��Ч��ClASS����ʾ��class�ļ�����Ч��SOURCE��ʾ��Դ�ļ�����Ч
@Retention(RetentionPolicy.RUNTIME)
// Target����˵����ע�������ʲô�ط�ʹ��
// ElementType.CONSTRUCTOR �������ڹ����� ElementType.FIELD:����������
// ElementType.METHOD�������ڷ��� ����Щһ�㳣�ã�
@Target({ ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface Fruit {
	String fruitColor() default "green";

	// ���������־��Ƕ�Ӧ�����Ե����֣�����ȡ�˵�ǰ�Զ���ע����Ķ���ʱ������ʹ�ã�����.������()�����صľ��ǵ�ǰע�����ķ�����Ӧ������ֵ
	String fruitName();

	String fruitProvider();

}
