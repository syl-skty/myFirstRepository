package indexOf������ʵ��;

public class student {
	int id;
	String name;

	public student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// ��дequals()����ʵ��indexOf()����
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		student other = (student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
