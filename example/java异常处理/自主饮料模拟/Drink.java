package ��������ģ��;

public abstract class Drink {
	public String tasted;

	public abstract String taste();

	public static Drink getDrink(int drinkType) throws DrinkNotFound {
		Drink mydrink = null;
		switch (drinkType) {
		case 1:
			mydrink = new Coffee("����");
			break;
		case 2:
			mydrink = new Milk("ţ��");
			break;
		case 3:
			mydrink = new Beer("ơ��");
			break;
		default:
			throw new DrinkNotFound();
		}
		return mydrink;
	}
}
