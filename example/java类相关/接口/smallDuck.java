package �ӿ�;

public class smallDuck extends allBird implements animal, bird, duck
//����̳�allBird�࣬��ʵ��animal bird,duck�ӿ�
{
public smallDuck(String name)
{
	this.name=name;
	System.out.println("����СѼ�Ӷ���ɹ�");
}
	@Override
	public void say() {
		// TODO Auto-generated method stub
System.out.println("����һֻСѼ��");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
System.out.println("���ܷ�");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
System.out.println("������");
	}

}
