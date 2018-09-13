package contains方法的重写;

//Set中因为没有下标，所以要先用HashCode()方法来比较其哈希码是否相同，若相同，再调用equals()方法来比较
//要实现contains()作用，就要重写hashCode()方法和equals()方法
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetcContains {
	public void testContains() {
		Set<course> courses = new HashSet<course>();
		course c1 = new course(1, "高数");
		course c2 = new course(2, "英语");
		course c3 = new course(3, "现代");
		course[] c = { c1, c2, c3 };
		courses.addAll(Arrays.asList(c));
		course c4 = new course(3, "高数");
		course c5 = new course(2, "英语");
		System.out.println("Set中是否包含" + c4 + ":" + courses.contains(c4));
		System.out.println("Set中是否包含" + c5 + ":" + courses.contains(c5));
	}
}
