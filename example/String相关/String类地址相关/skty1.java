package String���ַ���;

//�ַ�����������ֵ��ͬ�ı���ָ��ĵ�ַ��ͬ
public class skty1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "���";
		String b = "���";
		int f = 0;
		if (a == b)
			System.out.println("ab����String����ָ��ĵ�ַ��ͬ");
		else
			System.out.println("cd����String����ָ��ĵ�ַ����ͬ");

		// ����ֵ��ͬ��ָ���ַ��ͬ������������
		String c = new String("hello");
		String d = new String("hello");
		if (c == d)
			System.out.println("cd����String����ָ��ĵ�ַ��ͬ");
		else
			System.out.println("cd����String����ָ��ĵ�ַ����ͬ");

		// String���󴴽����޸�ֵʱ�������ڴ����ٴ���һ��ָ���ַ��ͬʱ֮ǰ��������Ȼ����
		a = a + "����";
		if (a == b)
			System.out.println("�޸ĺ�aûָ���µĵ�ַ");
		else
			System.out.println("�޸ĺ�aָ����һ���µĵ�ַ");
	}

}
