package 抽象类;

public class yaokong extends Tv {

	@Override
	public void open() // 子类必须实现抽象父类的抽象方法,只是抽象方法
	{
		System.out.println("电视已经打开啦!");
	}

	public yaokong(int size, String type) {
		super();
		this.size = size;
		this.type = type;
		System.out.println("已经创建一个遥控的对象 :size=" + size + "  type=" + type);
	}

	public void say() {
		System.out.println("我是子类say()方法");
	}

}
