package 自主饮料模拟;

public class Beer extends Drink {
	public final int type = 3;

	public Beer(String t) {
		// TODO Auto-generated constructor stub
		this.tasted = t;
	}

	@Override
	public String taste() {

		// TODO Auto-generated method stub
		return this.tasted;
	}

}
