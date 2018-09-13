package indexOf方法的实现;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//indexOf(指定对象)方法的功能是返回对象在集合中的索引值，同样，要比较对象的属性而不是指向地址必须重写equals()方法
//lastIndexOf()：返回最后的索引位置
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s1 = new student(1, "小明");
		student s2 = new student(2, "小花");
		student s3 = new student(2, "小花");
		List<student> students = new ArrayList<student>();
		student[] s = { s1, s2, s3 };
		students.addAll(Arrays.asList(s));
		student stu = new student(2, "小花");
		System.out.println("指定对象在List中的第一个索引位置为：" + students.indexOf(stu));
		System.out.println("指定对象在List中的最后一个索引位置为：" + students.lastIndexOf(stu));
	}

}
