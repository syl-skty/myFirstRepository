package ×ÔÖ÷ÒûÁÏÄ£Äâ;

public abstract class Drink {
	public String tasted;

	public abstract String taste();

	public static Drink getDrink(int drinkType) throws DrinkNotFound {
		Drink mydrink = null;
		switch (drinkType) {
		case 1:
			mydrink = new Coffee("¿§·È");
			break;
		case 2:
			mydrink = new Milk("Å£ÄÌ");
			break;
		case 3:
			mydrink = new Beer("Æ¡¾Æ");
			break;
		default:
			throw new DrinkNotFound();
		}
		return mydrink;
	}
}
