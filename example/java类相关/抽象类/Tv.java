package ������;

//ͨ�������������������������ʵ��ĳЩ����������עʵ�ֵ�ϸ��.
//�������޷�ֱ�Ӵ�������,�����Դ����������н�����Ķ���ʵ���ࣩ
public abstract class Tv {
	int size;
	String type;

	public Tv() {

	}

	public abstract void open();// �ڳ������ж�����󷽷����Բ���д������ͻ�����

	public void show() {
		System.out.println("����̨����");
	}
}
