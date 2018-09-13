package 静态代理;

/**
 * 被代理的类和实现代理功能的类都要实现同一个接口
 * 
 * @author skty
 *
 */
public class CountImp implements Count {

	@Override
	public void queryCount() {
		System.out.println("我在查询账户");
	}

	@Override
	public void updateCount() {
		System.out.println("我在更新账户");

	}

}
