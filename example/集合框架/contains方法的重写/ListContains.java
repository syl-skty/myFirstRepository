package contains方法的重写;

//contains()方法用来判断某个元素集中是否包含某个指定元素
//原理是遍历整个集合，用每个元素去调用自己的equals()方法来与指定元素比较。
//但未重写的equals()方法只是判断两个对象指向的地址是否相同，所以要比较其元素各个属性相同，必须重写equals()方法
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListContains {
	public void ListTest() {
		List<course> courses = new ArrayList<course>();
		course c1 = new course(1, "高数");
		course c2 = new course(2, "英语");
		course c3 = new course(3, "现代");
		course[] course1 = { c1, c2, c3 };
		courses.addAll(Arrays.asList(course1));// 将数组转化为List对象，再调用addAll（）方法来添加元素
												// Arrays.asList()
		course c0 = new course(2, "C语言");
		course c9 = new course(3, "现代");
		System.out.println("List中是否包含指定对象元素：" + c0 + "————————>"
				+ courses.contains(c0));
		System.out.println("List中是否包含指定对象元素：" + c9 + "————————>"
				+ courses.contains(c9));
		course[] course2 = { c1, c2, c9 };
		System.out.println("List中是否包含指定多个元素：" + course2[0] + ";" + course2[1]
				+ ";" + course2[2] + "————————>"
				+ courses.containsAll(Arrays.asList(course2)));
	}
}
