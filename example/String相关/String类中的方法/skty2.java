package String���еķ���;

//�ַ�����λ����0��ʼ
public class skty2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello everyone,I love java";
		// int length():���ص�ǰ�ַ����ĳ���
		System.out.println("��ǰ�ַ����ĳ���Ϊ��" + a.length());
		// int indexOf(char ch):����ch���ַ����е�һ�γ��ֵ�λ��
		System.out.println("�ַ�ll�ڵ�ǰ�ַ�����һ�γ��ֵ�λ��Ϊ��" + a.indexOf("ll"));
		// int lastIndexOf(char h):����h�ַ������ֵ�λ��
		System.out.println("l�ַ������ֵ�λ��Ϊ��" + a.lastIndexOf("l"));
		// >>>>>>>>>>���ϵ����λ�ò����ڻ��ַ��������򷵻�-1<<<<<<<

		// String subString(int beginIndex):���شӿ�ʼλ��beginIndex���������ַ���
		System.out.println("��3��λ����β���ַ���Ϊ:" + a.substring(3));
		System.out.println("��3��λ��9��λ���ַ���Ϊ��" + a.substring(3, 9));
		// String trim():����ȥ���ո���ַ���
		System.out.println("ȥ���ո����ַ���Ϊ��" + a.trim());
		// boolean equals(String b):�ж���b�ַ���ֵ�Ƿ����
		System.out.println("�ж�a��b�Ƿ���ȣ�" + a.equals("hi"));
		// String toLowercase():ת��ΪСд
		System.out.println("ת��ΪСд��Ϊ��" + a.toLowerCase());
		System.out.println("ת��Ϊ��дΪ��" + a.toUpperCase());
		// char charAt( int index):������indexλ���ϵ��ַ�
		System.out.println("��4��λ�ϵ��ַ�Ϊ��" + a.charAt(4));
		// String[] split(String regex,int limit):���ַ����Ϊ�ַ���������,ÿ�ε��ո�Ͳ��
		String[] b = a.split(" ");
		for (String i : b) {
			System.out.print(i + "\t");
		}
		System.out.println();
		// byte[] getBytes():���ַ���ת��Ϊ��byte����
		byte[] by = a.getBytes();
		for (byte i : by) {
			System.out.print(i + "\t");
		}
	}

}
