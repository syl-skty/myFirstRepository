package java�еİ�װ��;

//��Ϊint,float,double,boolean,char�Ȼ����������Ͳ��߱���������ʣ������޷����÷��������ܼ򵥡������Ƴ���װ�����ֲ��䲻��
public class skty4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(6);// Ҳ����"6"�����췽����ͬ��������һ��
		// Integer��װ���еķ�����
		byte by = a.byteValue();// ת��Ϊbyte����
		double dou = a.doubleValue();
		String b = a.toString();// ת��ΪString����
		int num = 666;
		b = ((Integer) num).toString();// ���Խ�������������ת��Ϊ��װ�����ͣ�Ȼ����ð�װ���еķ�����ʵ������ת��
		System.out.println("b=" + b);
		String c = "777";
		a = Integer.parseInt(c);// ���ð�װ���еľ�̬������ʵ���������͵������͵�ת��
		System.out.println("a=" + a);
	}

}
