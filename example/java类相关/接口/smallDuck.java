package 接口;

public class smallDuck extends allBird implements animal, bird, duck
//该类继承allBird类，并实现animal bird,duck接口
{
public smallDuck(String name)
{
	this.name=name;
	System.out.println("创建小鸭子对象成功");
}
	@Override
	public void say() {
		// TODO Auto-generated method stub
System.out.println("我是一只小鸭子");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
System.out.println("我能飞");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
System.out.println("我能走");
	}

}
