package example;

import java.util.HashSet;
import java.util.Set;

//set接口存放的元素为不可重复的无序的， 被称为集合,由于set中的元素无序，即元素没有下标index.
//set接口存在一个实现类HashSet,
public class testSet {
	public void Settest() {
		Set<student> students = new HashSet<student>();// 定义Set students(泛型)
		student s1 = new student(1, "bob", 13);
		student s2 = new student(2, "tom", 17);
		student s3 = new student(3, "mike", 15);
		students.add(null);// set中可以存放null
		students.add(s1);// 不能指定位置插入，因为set为无序的
		students.add(s2);
		students.add(s2);
		students.add(s3);
		// 遍历Set students,使用foreach,不能用for()语句:没有下标
		System.out.println("set student 中的元素为：");
		for (student s : students) {
			System.out.println(s);
		}
		students.remove(s2);// 删除指定元素
		System.out.println("删除s2后Set中的元素为：");
		for (student s : students) {
			System.out.println(s);
		}
	}
}
