package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

	public static void main(String[] args) {
		List<Connection> connections = new ArrayList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");// �������ݿ���������
			String url = "jdbc:mysql://127.0.0.1:3306/xg?characterEncoding=utf-8";
			String user = "root";
			String password = "4394";
			for (int i = 0; i < 5; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);// ��ȡ����
				connections.add(connection);
			}
			System.out.println(connections.size());

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
