package ������;

public class yaokong extends Tv {

	@Override
	public void open() // �������ʵ�ֳ�����ĳ��󷽷�,ֻ�ǳ��󷽷�
	{
		System.out.println("�����Ѿ�����!");
	}

	public yaokong(int size, String type) {
		super();
		this.size = size;
		this.type = type;
		System.out.println("�Ѿ�����һ��ң�صĶ��� :size=" + size + "  type=" + type);
	}

	public void say() {
		System.out.println("��������say()����");
	}

}
