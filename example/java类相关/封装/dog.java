package ��װ;

//��װ�ķ�ʽ�ܹ�ͨ�������Եķ���������Ϊprivate��˽�У��ģ�Ȼ������ԵĲ���Ҫ�������Ե�getter��setter������
//���ⲿ�����޷�ֱ�ӷ��ʵ���ͬʱ������getter��setter������ͬʱ������ĳЩ���������ƶ����ԵĲ�����
public class dog {
	private String name;// ����1�� ����������Ϊprivate�ɼ��ԣ�ֻ��������ʣ�
	private int age;

	// ����2:����get��set�����������Խ����޸ķ���
	public String getName() {
		return name;
	}

	public void setName(String name) {
		// �ڱ����п���ֱ�ӵ��ã�����Ҫʹ��getter��setter����,�ⲿ��Ҫʹ��
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// ����3����get,set�����ж�����ֵ������Ӧ�淶
		if (age <= 0 || age > 20) {
			System.out.println("�����age���Ϸ���������0~20��");
		} else
			this.age = age;
	}

}
