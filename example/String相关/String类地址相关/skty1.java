package String类地址相关;

//字符变量中两个值相同的变量指向的地址相同
public class skty1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "你好";
		String b = "你好";
		int f = 0;
		if (a == b)
			System.out.println("ab两个String变量指向的地址相同");
		else
			System.out.println("cd两个String变量指向的地址不相同");

		// 创建值相同但指向地址不同的两个变量：
		String c = new String("hello");
		String d = new String("hello");
		if (c == d)
			System.out.println("cd两个String变量指向的地址相同");
		else
			System.out.println("cd两个String变量指向的地址不相同");

		// String对象创建后被修改值时，会在内存中再创建一个指向地址，同时之前的数据仍然还在
		a = a + "朋友";
		if (a == b)
			System.out.println("修改后a没指向新的地址");
		else
			System.out.println("修改后a指向了一个新的地址");
	}

}
