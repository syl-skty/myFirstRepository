package ����UDP������ͨ��;

public class Cient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UDPUtil.createClient("localhost", 8800);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
