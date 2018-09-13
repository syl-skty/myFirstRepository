package contains方法的重写;

import java.util.HashMap;
import java.util.Map;

//Map中的contains()方法，包括containsKey()和containsValue()方法
//其中这两个方法都是调用equals()方法来进行判断的
public class MapContains {
	public void testMap() {
		Map<Integer, course> courses = new HashMap<Integer, course>();// 定义泛型,其中key要用包装类，value用course类
		course c1 = new course(1, "高数");
		course c2 = new course(2, "语文");
		course c3 = new course(3, "线代");
		course[] c = { c1, c2, c3 };
		for (int i = 0; i < 3; i++) {
			courses.put(i, c[i]);
		}
		course c4 = new course(2, "语文");
		System.out.println("value是否包含" + courses.containsValue(c4));
		System.out.println("key中否包含" + courses.containsKey(2));
	}
}
