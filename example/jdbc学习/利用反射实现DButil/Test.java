package ���÷���ʵ��DButil;

public class Test {
	public String a;

	public static void main(String[] args) {
		String sql = "insert into user values(?,?,?)";
		System.out.println(Dbutil.update(sql, 6, "С��ɱ", "asa"));
		// List<Bean> bs = Dbutil.queryList(sql, Bean.class);
		// System.out.println(bs.size());
		// for (Bean bean : bs) {
		// System.out.println(bean.getName());
		// }

	}

}
