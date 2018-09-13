package java中的包装类;

//因为int,float,double,boolean,char等基本数据类型不具备对象的性质，它们无法调用方法，功能简单。所以推出包装类来弥补其不足
public class skty4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(6);// 也可用"6"，构造方法不同，但对象一样
		// Integer包装类中的方法：
		byte by = a.byteValue();// 转换为byte类型
		double dou = a.doubleValue();
		String b = a.toString();// 转换为String类型
		int num = 666;
		b = ((Integer) num).toString();// 可以将基本数据类型转换为包装类类型，然后调用包装类中的方法来实现类型转换
		System.out.println("b=" + b);
		String c = "777";
		a = Integer.parseInt(c);// 调用包装类中的静态方法来实现其他类型到本类型的转换
		System.out.println("a=" + a);
	}

}
