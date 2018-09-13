package 利用反射实现DButil;

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
 * 数据库连接操作的一个工具类 通过这个工具类，
 * 
 * 可以实现对所有的指定的数据库sql语句进行操作
 * 
 * 使用此工具类执行查询操作有以下要求：
 * 
 * 1.实体类必须有setter方法
 * 
 * 2.实体类的类型要与数据库表的类型一致
 * 
 * 3.实体类的set方法必须是setName()方式，首字母大写
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
	static {// 读取数据库连接参数，加载驱动
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
	 * 获取数据库的连接
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
	 * 对指定的sql语句执行查询操作
	 * 
	 * @param sql
	 *            指定的sql语句
	 * @param clz
	 *            查询到的实体类的类类型
	 * @param params
	 *            sql语句中的参数
	 * @return 一个封装了所有数据表中的数据的list集合
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
					util.doInvoke(field, bean, rs, clz);// 调用注入方法
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
	 * 执行更新操作的sql语句，带事务处理
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param params
	 *            sql语句执行的参数
	 * @return
	 */
	public static boolean update(String sql, Object... params) {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);// 设置自动提交事务为false,表示自己处理事务
		} catch (SQLException e1) {
			e1.printStackTrace();
			util.close(conn, pst, null);
			return false;
		}
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {

				pst.setString(i, String.valueOf(params[i - 1]));// 设置参数

			}

			pst.execute();// 执行语句
			conn.commit();// 提交事务
			util.close(conn, pst, null);
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();// 异常时自动回滚
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
	 * 关闭连接，释放资源
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
	 * 执行数据注入的操作
	 * 
	 * @param field
	 *            属性名
	 * @param obj
	 *            要注入的实体类对象
	 * @param rs
	 *            数据库结果集
	 * @param c
	 *            实体类的类类型
	 * @throws Exception
	 */
	private <T> void doInvoke(Field field, Object obj, ResultSet rs, Class<T> c) throws Exception {
		Class<?> type = field.getType();

		String fieldName = field.getName();// 获取属性的名字

		StringBuilder builder = new StringBuilder();

		builder.append("set").append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));

		String seterName = builder.toString();// 得到与属性对应的set方法名称

		Method method = c.getMethod(seterName, type);// 获取对应的set方法

		method.invoke(obj, type.cast(rs.getObject(fieldName)));// 调用set方法，使用cast（）方法将rs中的数据类型强转
	}

}
