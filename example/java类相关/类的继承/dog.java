package 类的继承;


public class dog extends animal {
	int age;

	public dog(int age, String color) {
		super();// 在子类重写构造方法时，在构造方法的第一行要调用父类的无参构造函数(super（）),因为要创建子类对象，先要调用父类隐形对象来创建子类对象
		this.age = age;
		this.color = color;
	}

	public void show()// 方法重写，重写父类的方法
	{
		super.say();// 用super代表父类，调用父类方法属性时直接用(super.方法/属性)
		System.out.println("I am a dog");
	}

	@Override
	public String toString()// object类是所有类的父类，里面定义了toString方法，重写此方法可以直接用System.out.println(对象)打印输出对象的相关属性，如果不重写，则输出为对象存储的地址
	{
		return "dog [age=" + age + "  color=" + color + "   food=" + food + "]";
	}

	public boolean equals(Object obj)// object类是所有类的父类，里面定义了equals方法，重写此方法可以判断两个对象是否相同
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		return true;
	}
}
