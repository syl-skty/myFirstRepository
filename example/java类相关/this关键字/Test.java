package this�ؼ���;

public class Test {
	public String a = "�ֵ�";

	public void sayHello() {
		System.out.println("hello!");
	}

	public void show() {
		// this�ؼ��ֿɱ�ʾ��ǰ���ø÷����Ķ��󣬿���ͨ���˶��������������Ժͷ���
		this.sayHello();
		System.out.println("���" + this.a);
	}

}
