package �Զ���ע��;

public class Apple {
	@Fruit(fruitColor = "red", fruitName = "�츻ʿ", fruitProvider = "�ձ�")
	public Fruit fruit;

	public Apple() {
	}

	@Fruit(fruitColor = "red", fruitName = "�츻ʿ", fruitProvider = "ɽ����̨")
	public Apple(String name, String color, String provider) {

	}

	// ʹ��ע��ʱ���ڶ�ӦҪʹ�õ�λ���Ϸ�ʹ���Զ���ע���������֣���������ţ�������������Խ��и�ֵ����Щ������Ĭ��ֵ�����Կ���ʡ��
	@Fruit(fruitName = "��ȫ", fruitProvider = "�ձ�")
	public void message() {

	}

}
