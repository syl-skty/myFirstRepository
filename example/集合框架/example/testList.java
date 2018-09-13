package example;

//List中存放有序可重复的对象元素。是常用的集合。
//List 接口存在两个实现类：ArrayList ,LinkList. 可以用这两个实现类来创建List对象来存放集合数组。
import java.util.ArrayList;
import java.util.List;

public class testList {
	public void Listtest() {
		List<student> students = new ArrayList<student>(); // 定义泛型，将List设置为泛型，students中只能存放student对象元素
		// 调用student类中含参构造方法创建对象
		student s1 = new student(1, "小明", 15);
		student s2 = new student(2, "小花", 18);
		// 调用add()方法来对students添加对象元素：自动添加在末尾
		students.add(s1);
		students.add(s2);
		System.out.println("现在List students中的元素顺序为：");
		for (int i = 0; i < students.size(); i++)// 调用List中的size（）方法来获取Students的长度
		{
			student s = students.get(i);
			System.out.println("位置" + i + " " + s);// 此时直接写student对象s会自动调用重写的toString()方法
		}

		student s3 = new student(3, "小胖", 12);
		// 调用add(位置，对象)来插入一个对象
		students.add(2, s3);
		System.out.println("插入元素后的List students中元素顺序为：");
		for (int i = 0; i < students.size(); i++)// 调用List中的size（）方法来获取Students的长度
		{
			student s = students.get(i);
			System.out.println("位置" + i + " " + s);// 此时直接写student对象s会自动调用重写的toString()方法
		}

		List<student> L1 = new ArrayList<student>();
		L1.add(s2);
		L1.add(s3);
		// 调用addAll(位置，另一个List对象)来插入元素，也可以用addAll(另一个List对象)来追加在末尾
		students.addAll(2, L1);
		System.out.println("插入另一个List对象后的students元素顺序为：");
		for (int i = 0; i < students.size(); i++)// 调用List中的size（）方法来获取Students的长度
		{
			student s = students.get(i);
			System.out.println("位置" + i + " " + s);// 此时直接写student对象s会自动调用重写的toString()方法
		}

		student s4 = new student(6, "小虎", 20);
		students.set(2, s4);// 调用set（） 方法来修改List指定的元素
		students.remove(3);// 调用remove()方法来删除指定位置的元素
		System.out.println("执行修改删除后的students元素顺序为：");
		for (int i = 0; i < students.size(); i++)// 调用List中的size（）方法来获取Students的长度
		{
			student s = students.get(i);
			System.out.println("位置" + i + " " + s);// 此时直接写student对象s会自动调用重写的toString()方法
		}

	}
}
