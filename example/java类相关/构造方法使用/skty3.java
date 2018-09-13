package 构造方法使用;
//每次创建一个新的类时，都会自动创建一个没有返回值的构造函数，通过调用此构造函数来创建新的对象：dog d1=new dog();dog()为默认构造函数。
//我们可以通过重载构造函数来实现对每个新建对象的初始化。
public class skty3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
dog d1=new dog("可乐","黄");
System.out.println("我是一只"+d1.color+"狗，名字为"+d1.name);
	}

}
