package �ڲ������;
//��̬�ڲ������
public class dog {
String color="red";
static double w=20.5;
public void cut(){
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}
public static void cut2()
{
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}
public static class sdog{
	int weight;
	String color;
	public void show(){
		dog d1=new dog();
		weight=(int)w;//��̬�ڲ������ֱ�ӷ����ⲿ���еľ�̬����
		color=d1.color;//����ֱ�ӷ����ⲿ���еķǾ�̬���������봴���ⲿ��Ķ�����ܷ���
		d1.cut();//�Ǿ�̬����Ҳ����ֱ�ӷ���
		System.out.println("weight:"+weight+"    color:"+color);
		cut2();//��̬��������ֱ�ӷ���
	}
}

}
