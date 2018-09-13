package Collection类中的sort方法;

//Collection.Sort()方法可以对List中的元素按一定的顺序排序
//如果List中存放的是基本数据类型，可直接使用方法排序。
//当存放的是自定义对象时要调用这个方法就必须用对象所在的类实现comparable接口，重写compareto()方法，将其自定义为自己规定的对比规则
public class student implements Comparable<student> {
	int age;
	String name;

	public student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	// 重写compareTo方法实现比较两个对象的age
	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		// 用age调用Integer包装类已经写好的compareTo()方法来比较两个age的大小，并返回一个值，也可用if语句来判断两个age的大小
		return ((Integer) this.age).compareTo(o.age);
	}

	@Override
	public String toString() {
		return "student [age=" + age + ", name=" + name + "]";
	}

}
