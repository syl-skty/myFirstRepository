package 适配器模式_类适配器;

public class Test {
	public static void main(String[] args) {
		// 使用适配器对象来调用方法
		ClassAdapter adapter = new ClassAdapter();
		adapter.doWork();
		adapter.method1();
	}
}
