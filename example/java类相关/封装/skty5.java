package ��װ;

//ͨ����װ�����Խ���������������ڲ�����緽���޷�ֱ�ӷ��ʺ��޸����ݣ�����ͨ��get()��set()��������ȡ���޸�����
public class skty5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dog d1 = new dog();
		// ��װ��Զ�����Ӧ���Խ����޸�ʱ����ʹ��setter()������������ֱ��д������.���ԣ�
		d1.setAge(3);
		d1.setName("����");
		// ��ȡʱҪʹ��get()����
		System.out.println("�ҽ�" + d1.getName() + "  ����Ϊ��  " + d1.getAge());

	}

}
