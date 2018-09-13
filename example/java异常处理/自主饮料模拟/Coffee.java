package 自主饮料模拟;

public class Coffee extends Drink {
	public final int type = 1;

	public Coffee(String t) {
		// TODO Auto-generated constructor stub
		this.tasted = t;
	}

	@Override
	public String taste() {

		// TODO Auto-generated method stub
		return this.tasted;
	}

}
