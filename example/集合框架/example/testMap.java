package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Map 中存放的是一对对的键值对<key,value>,一个key只能指向一个value，但一个value可以对应多个key,key和value都可以为null
//Map的实现类为HashMap
//Map中的键值对存放为Entry对象,Entry为一个类
public class testMap {
	public void MapTest() {
		// 定义Map泛型，将key 设置为整型，将存放的value规定为student类型
		// 因为基本数据类型不能使用泛型，所以这里不用int 要使用其包装类Integer
		Map<Integer, student> students = new HashMap<Integer, student>();
		student s1 = new student(1, "qqq", 12);
		student s2 = new student(2, "www", 15);
		students.put(1, s1);// 调用put()方法来添加元素
							// 使用remove(key值)方法来删除key对应的键值对,使用put(key，修改后的对象)来修改
		students.put(2, s2);
		System.out.println("取得key为1的value为：" + students.get(1).toString());// 调用get(key值)来获取对应的value值

		// 调用Map中的keySet()方法来获取所有key值的集合返回为Set类型
		Set<Integer> keyset = students.keySet();
		System.out.println("所有的key值为：");
		for (int a : keyset) {
			System.out.print(" " + a);
		}
		System.out.println();
		// 调用entrySet()来返回所有的键值对,返回值为包含泛型为Entry类型的Set(集合)，即Set<Entry>类型
		Set<Entry<Integer, student>> entrySet = students.entrySet();// 前面的键值对为<Integer,student>类型,这里也要一样
		System.out.println("Map中所有的键值对为：");
		for (Entry<Integer, student> e : entrySet) {
			System.out.println("键为：" + e.getKey() + ";值为：" + e.getValue());
		}
	}
}
