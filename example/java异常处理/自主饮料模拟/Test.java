package ��������ģ��;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {

			System.out.print("��������Ҫ���ϵ����ͣ�");
			int type = input.nextInt();
			Drink d = Drink.getDrink(type);
			System.out.println("��ǰ����ζ��Ϊ" + d.taste());
		} catch (DrinkNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

}
