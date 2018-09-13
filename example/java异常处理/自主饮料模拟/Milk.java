package 自主饮料模拟;

public class Milk extends Drink {
	public final int type = 2;

	public Milk(String t) {

		// TODO Auto-generated constructor stub
		this.tasted = t;
	}

	@Override
	public String taste() {

		// TODO Auto-generated method stub
		return this.tasted;
	}

}
