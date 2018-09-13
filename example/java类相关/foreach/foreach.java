package foreach;

public class foreach {
	// for each������������Ԫ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 6, 7, 8, 9, 10 };
		String[] b = new String[3];
		b[0] = "a";
		b[1] = "b";
		b[2] = "c";
		double c[] = { 1.0, 2.0, 3.0 };
		System.out.println("����a����");
		for (int i : a) {
			int j = 1;// ��foreach�м���j������j��ֵ������foreach�仯
			System.out.println("��" + j + "��Ԫ�أ�" + i);
			j++;
		}
		System.out.println("����b����");
		for (String i : b) {
			int j = 1;
			System.out.println("��" + j + "��Ԫ�أ�" + i);
		}
		System.out.println("����c����");
		for (Double i : c) {
			int j = 1;
			System.out.println("��" + j + "��Ԫ�أ�" + i);
		}
	}

}
