package org.dbsoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String url = "jdbc:mysql://localhost:3306/demo1";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "root";
	private static Connection con = null;

	/**
	 * 加载驱动
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库相关连接 关闭顺序 resultSet -- statement -- con
	 * @param con
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection con, Statement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null) {
						con.close();
						con = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
