package �������л��뷴���л�����;

import java.io.IOException;
import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int age;
	private transient String sex;// ��transient���ε����Բ��ᱻ�����Ĭ�����л��ͷ����л����������Լ�����������л�

	public Student() {

	}

	private void writeObject(java.io.ObjectOutputStream s) throws IOException// �Զ������л�����
	{
		s.defaultWriteObject();// �Ƚ�����Ĭ�����л�������������л�
		s.writeObject(sex);// ����transient���ε������Լ����л�
		// ���ﲻ��Ҫs.close(),���׳��쳣
	}

	private void readObject(java.io.ObjectInputStream s)
			throws ClassNotFoundException, IOException// �Զ��巴���л�����
	{
		s.defaultReadObject();// ��Ĭ�Ͽ��Ա������л������Է����л�
		sex = (String) s.readObject();// �������Ա�Ĭ�Ϸ����л��������Լ������л�
		// ���ﲻ��Ҫs.close(),���׳��쳣
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
