package Class��������ʶ;

/*
 * �����඼��Class���һ������ÿ�δ���һ�����൱�ڴ�����һ��Class���ʵ������
 * Ҫ��ȡһ����������������ַ�ʽ��
 * 1: ����.class��ʽ��ȡ��ÿ�������͵Ķ�����һ�������ľ�̬����class
 * 2: �����.getClass()������ȡ���Ӧ��������
 * 3: Class.forName(���ȫ��) ͨ��Class���еľ�̬������ȡһ��ָ����ȫ�Ƶ�������
 */
public class TestClassType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c1 = foo.class;// ͨ��������ȡ
		Class c2 = (new foo()).getClass();// ͨ��������ȡ�����͡�

		try {
			Class c3 = Class.forName("Class��������ʶ.foo");// ͨ��Class.forName()��ȡ
			System.out.println(c1 == c2);
			System.out.println(c2 == c3);// ���ַ�ʽ ��ȡ�������Ͷ�����ͬ��
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class foo// ����һ�����Ե���
{

}
