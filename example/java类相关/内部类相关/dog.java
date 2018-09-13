package 内部类相关;
//静态内部类解释
public class dog {
String color="red";
static double w=20.5;
public void cut(){
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}
public static void cut2()
{
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}
public static class sdog{
	int weight;
	String color;
	public void show(){
		dog d1=new dog();
		weight=(int)w;//静态内部类可以直接访问外部类中的静态变量
		color=d1.color;//不能直接访问外部类中的非静态变量，必须创建外部类的对象才能访问
		d1.cut();//非静态方法也不能直接访问
		System.out.println("weight:"+weight+"    color:"+color);
		cut2();//静态方法可以直接访问
	}
}

}
