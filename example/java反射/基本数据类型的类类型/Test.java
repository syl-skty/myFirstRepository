package 基本数据类型的类类型;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class intc = int.class;// 获取int基本数据类型的类类型
		System.out.println(intc.getName());// int
		Class Stringc = String.class;
		System.out.println(Stringc.getName());// java.lang.String
		System.out.println(Stringc.getSimpleName());// String
		Class doublec = double.class;// double数据类型的类类型
		Class Doublec = Double.class;// Double类的类类型

	}

}
