package Collection类中的sort方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1.实现接口comparable 和其compareTo()方法
//2.实现接口comparator 和其compare()方法
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s1 = new student(15, "小明");
		student s2 = new student(11, "小虎");
		student s3 = new student(17, "小豆");
		student[] s = { s1, s2, s3 };
		List<student> l1 = new ArrayList<student>();
		book b1 = new book(2, "高数");
		book b2 = new book(3, "英语");
		book b3 = new book(1, "语文");
		List<book> l2 = new ArrayList<book>();
		book[] b = { b1, b2, b3 };
		l1.addAll(Arrays.asList(s));
		l2.addAll(Arrays.asList(b));
		Collections.sort(l1);
		bookCompare bc = new bookCompare();// 创建book自定义的比较对象
		Collections.sort(l2, bc);// 用Collection.sort(list对象,定义的规则对象)来实现
		System.out.println("student类排序后结果：");
		for (student stu : l1) {
			System.out.println(stu);
		}
		System.out.println("book类排序后结果：");
		for (book bo : l2) {
			System.out.println(bo);
		}
	}

}
