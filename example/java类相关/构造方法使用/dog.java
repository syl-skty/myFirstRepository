package ���췽��ʹ��;

import java.util.ArrayList;
import java.util.List;

public class dog {
	String name;
	String color;
	List<String> food;// ����һ��List�������ԣ���ʾʳ�õ�����ʳ��

	public dog(String name, String color)// ���ع��캯�������½��Ķ���ֵ����ʼ�������Ϊvoid���Բ�д
	{
		this.color = color;// this�ؼ��ֱ�ʾ���ô˷����Ķ���
		this.name = name;
		food = new ArrayList<String>();// ͬʱ��ÿ�����󴴽�һ��list�������ڴ��food Ԫ��

	}
}
