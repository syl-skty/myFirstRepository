package 对象序列化与反序列化操作;

import java.io.IOException;
import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int age;
	private transient String sex;// 由transient修饰的属性不会被虚拟机默认序列化和反序列化，但可以自己定义完成序列化

	public Student() {

	}

	private void writeObject(java.io.ObjectOutputStream s) throws IOException// 自定义序列化规则
	{
		s.defaultWriteObject();// 先将可以默认序列化的属性完成序列化
		s.writeObject(sex);// 将被transient修饰的属性自己序列化
		// 这里不需要s.close(),会抛出异常
	}

	private void readObject(java.io.ObjectInputStream s)
			throws ClassNotFoundException, IOException// 自定义反序列化规则
	{
		s.defaultReadObject();// 将默认可以被反序列化的属性反序列化
		sex = (String) s.readObject();// 将不可以被默认反序列化的属性自己反序列化
		// 这里不需要s.close(),会抛出异常
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
