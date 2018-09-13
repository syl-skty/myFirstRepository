package 自主饮料模拟;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {

			System.out.print("请输入你要饮料的类型：");
			int type = input.nextInt();
			Drink d = Drink.getDrink(type);
			System.out.println("当前饮料味道为" + d.taste());
		} catch (DrinkNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

}
