package 构造方法使用;

import java.util.ArrayList;
import java.util.List;

public class dog {
	String name;
	String color;
	List<String> food;// 加入一个List集合属性，表示食用的所有食物

	public dog(String name, String color)// 重载构造函数来对新建的对象赋值，初始化，如果为void可以不写
	{
		this.color = color;// this关键字表示调用此方法的对象
		this.name = name;
		food = new ArrayList<String>();// 同时对每个对象创建一个list对象，用于存放food 元素

	}
}
