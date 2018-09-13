package 取钱过程;

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
			System.out.print("请输入用户名:");
			String userName = input.next();
			System.out.print("请输入密码:");
			String passWord = input.next();
			if ("s".equals(userName) && "123456".equals(passWord)) {
				break;
			} else {
				while (true) {
					System.out.print("账号或密码错误，是否重新登陆：");
					conti = input.next();
					if ("N".equals(conti)) {
						System.out.println("退出成功");
						return;
					} else if ("Y".equals(conti)) {
						break;
					} else {
						System.out.println("请正确输入Y或者N");
					}
				}
			}
		}
		System.out.print("输入要取的金额：");
		try {
			input.nextInt();
			System.out.println("取钱成功");
		} catch (Exception e) {
			throw new Num_not_int_Exception();
		}

	}
}
