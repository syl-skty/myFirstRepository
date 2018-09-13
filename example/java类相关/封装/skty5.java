package 封装;

//通过封装，可以将数据隐藏在类的内部，外界方法无法直接访问和修改数据，必须通过get()和set()方法来读取和修改数据
public class skty5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dog d1 = new dog();
		// 封装后对对象相应属性进行修改时必须使用setter()方法，而不能直接写（对象.属性）
		d1.setAge(3);
		d1.setName("菠菜");
		// 读取时要使用get()方法
		System.out.println("我叫" + d1.getName() + "  年龄为：  " + d1.getAge());

	}

}
