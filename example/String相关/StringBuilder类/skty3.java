package StringBuilder类;

public class skty3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder a = new StringBuilder("hello");
		StringBuilder b = new StringBuilder("hello");
		System.out.println("两个对象的地址是否相同:" + a.equals(b));
		a = a.append(" you");
		// StringBuilder类对象在修改时会把之前的指向地址删掉，而String类不会删掉
		// StringBuilder类中的方法
		// StringBuilder append(参数):将参数追加到末尾
		a.append(" !");
		// StringBuilder insert(位置，参数):在指定位置插入参数
		a.insert(6, "fuck ");
		// String toString():将StringBuilder类型转换为String类型
		String c = a.toString();
		// int length():返回长度
		System.out.println("StringBuilder a为：" + a + "\n" + "String c为：" + c
				+ "\n" + "a 的长度为：" + a.length());
	}

}
