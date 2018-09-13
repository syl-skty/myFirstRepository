package example;

public class student {
	private int id;
	private String name;
	private int age;

	public student(int id, String name, int age) {
		this.setAge(age);
		this.setName(name);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
