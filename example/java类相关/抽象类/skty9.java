package 抽象类;

public class skty9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv1 = new yaokong(32, "big");// 抽象类不能创建对象，必须借助实现子类来创建对象
		tv1.open();
		tv1.show();
	}

}
