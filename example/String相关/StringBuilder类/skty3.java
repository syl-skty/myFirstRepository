package StringBuilder��;

public class skty3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder a = new StringBuilder("hello");
		StringBuilder b = new StringBuilder("hello");
		System.out.println("��������ĵ�ַ�Ƿ���ͬ:" + a.equals(b));
		a = a.append(" you");
		// StringBuilder��������޸�ʱ���֮ǰ��ָ���ַɾ������String�಻��ɾ��
		// StringBuilder���еķ���
		// StringBuilder append(����):������׷�ӵ�ĩβ
		a.append(" !");
		// StringBuilder insert(λ�ã�����):��ָ��λ�ò������
		a.insert(6, "fuck ");
		// String toString():��StringBuilder����ת��ΪString����
		String c = a.toString();
		// int length():���س���
		System.out.println("StringBuilder aΪ��" + a + "\n" + "String cΪ��" + c
				+ "\n" + "a �ĳ���Ϊ��" + a.length());
	}

}
