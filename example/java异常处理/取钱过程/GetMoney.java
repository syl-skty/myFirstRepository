package ȡǮ����;

import java.util.Scanner;

public class GetMoney {
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			new GetMoney().getmoney();
		} catch (Num_not_int_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getmoney() throws Num_not_int_Exception {
		String conti = "";
		while (true) {
			System.out.print("�������û���:");
			String userName = input.next();
			System.out.print("����������:");
			String passWord = input.next();
			if ("s".equals(userName) && "123456".equals(passWord)) {
				break;
			} else {
				while (true) {
					System.out.print("�˺Ż���������Ƿ����µ�½��");
					conti = input.next();
					if ("N".equals(conti)) {
						System.out.println("�˳��ɹ�");
						return;
					} else if ("Y".equals(conti)) {
						break;
					} else {
						System.out.println("����ȷ����Y����N");
					}
				}
			}
		}
		System.out.print("����Ҫȡ�Ľ�");
		try {
			input.nextInt();
			System.out.println("ȡǮ�ɹ�");
		} catch (Exception e) {
			throw new Num_not_int_Exception();
		}

	}
}
