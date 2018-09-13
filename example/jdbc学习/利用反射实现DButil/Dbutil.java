package ���÷���ʵ��DButil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * ���ݿ����Ӳ�����һ�������� ͨ����������࣬
 * 
 * ����ʵ�ֶ����е�ָ�������ݿ�sql�����в���
 * 
 * ʹ�ô˹�����ִ�в�ѯ����������Ҫ��
 * 
 * 1.ʵ���������setter����
 * 
 * 2.ʵ���������Ҫ�����ݿ�������һ��
 * 
 * 3.ʵ�����set����������setName()��ʽ������ĸ��д
 * 
 * @author skty
 *
 */
public class Dbutil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Dbutil util = new Dbutil();
	static {// ��ȡ���ݿ����Ӳ�������������
		Properties properties = new Properties();
		try {
			properties.load(Dbutil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ������
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ָ����sql���ִ�в�ѯ����
	 * 
	 * @param sql
	 *            ָ����sql���
	 * @param clz
	 *            ��ѯ����ʵ�����������
	 * @param params
	 *            sql����еĲ���
	 * @return һ����װ���������ݱ��е����ݵ�list����
	 */
	public static <T> List<T> queryList(String sql, Class<T> clz, Object... params) {
		List<T> resultList = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setString(i, String.valueOf(params[i]));
			}
			rs = pst.executeQuery();
			resultList = new ArrayList<T>();
			while (rs.next()) {
				T bean = clz.newInstance();
				Field[] declaredFields = clz.getDeclaredFields();
				for (Field field : declaredFields) {
					util.doInvoke(field, bean, rs, clz);// ����ע�뷽��
				}
				resultList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pst, rs);
		}
		return resultList;
	}

	/**
	 * ִ�и��²�����sql��䣬��������
	 * 
	 * @param sql
	 *            Ҫִ�е�sql���
	 * @param params
	 *            sql���ִ�еĲ���
	 * @return
	 */
	public static boolean update(String sql, Object... params) {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);// �����Զ��ύ����Ϊfalse,��ʾ�Լ���������
		} catch (SQLException e1) {
			e1.printStackTrace();
			util.close(conn, pst, null);
			return false;
		}
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {

				pst.setString(i, String.valueOf(params[i - 1]));// ���ò���

			}

			pst.execute();// ִ�����
			conn.commit();// �ύ����
			util.close(conn, pst, null);
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();// �쳣ʱ�Զ��ع�
				util.close(conn, pst, null);
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * �ر����ӣ��ͷ���Դ
	 * 
	 * @param con
	 * @param pst
	 * @param rs
	 */
	private void close(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (pst != null) {
				pst.close();
			}
			if (rs != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ִ������ע��Ĳ���
	 * 
	 * @param field
	 *            ������
	 * @param obj
	 *            Ҫע���ʵ�������
	 * @param rs
	 *            ���ݿ�����
	 * @param c
	 *            ʵ�����������
	 * @throws Exception
	 */
	private <T> void doInvoke(Field field, Object obj, ResultSet rs, Class<T> c) throws Exception {
		Class<?> type = field.getType();

		String fieldName = field.getName();// ��ȡ���Ե�����

		StringBuilder builder = new StringBuilder();

		builder.append("set").append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));

		String seterName = builder.toString();// �õ������Զ�Ӧ��set��������

		Method method = c.getMethod(seterName, type);// ��ȡ��Ӧ��set����

		method.invoke(obj, type.cast(rs.getObject(fieldName)));// ����set������ʹ��cast����������rs�е���������ǿת
	}

}
