package 适配器模式_对象适配器;

/**
 * 对象适配器模式，与类适配器的作用相同，都是实现间接让一个无法修改的某个类实现指定的接口的效果
 * 
 * 不同的是，类适配器是通过让适配器类继承源类同时实现指定接口，
 * 
 * 对象适配器是通过让适配器类实现指定接口，同时在适配器类中加入一个源类的对象
 * 
 * @author skty
 *
 */
public class ObjectAdapter implements Target {

	// 使用对象适配器模式，在适配器类中添加一个源类中的对象
	private Source source;

	/**
	 * 通过构造函数实现初始化源类对象
	 * 
	 * @param source
	 */
	public ObjectAdapter(Source source) {
		this.source = source;
	}

	@Override
	public void doWork() {
		// 在实现的对应的接口方法中使用源类对象来调用对应的方法
		source.doSourceWork();
	}

	@Override
	public void method() {
		source.doMethod();
	}

}
