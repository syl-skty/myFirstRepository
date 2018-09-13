package 封装;

//封装的方式能够通过对属性的访问性设置为private（私有）的，然后对属性的操作要借助属性的getter和setter方法。
//让外部程序无法直接访问到（同时可以在getter和setter方法中同时设置了某些规则来限制对属性的操作）
public class dog {
	private String name;// 步骤1： 将属性声明为private可见性（只允许本类访问）
	private int age;

	// 步骤2:创建get和set方法来对属性进行修改访问
	public String getName() {
		return name;
	}

	public void setName(String name) {
		// 在本类中可以直接调用，不需要使用getter和setter方法,外部类要使用
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// 步骤3：在get,set方法中对属性值进行相应规范
		if (age <= 0 || age > 20) {
			System.out.println("输入的age不合法，必须在0~20内");
		} else
			this.age = age;
	}

}
