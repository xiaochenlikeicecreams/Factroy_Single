package org.dbsoft.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteCRUD extends DBUtil{

	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	
	/**
	 * 
	 * @param sql
	 * @param objects 必须和SQL语句中的问号一一对应
	 * @return
	 */
	public boolean executeCreateAndUpdateAndDelete(String sql , Object[] objects) {
		boolean b = false;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
			if(objects != null) {
				
				for(int i = 0 ; i < objects.length ; i++) {
					pstmt.setObject(i+1, objects[i]);
				}
				
			}
			
			int row = pstmt.executeUpdate();
			
			if(row > 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}
		return b;
	}
	/**
	 * 
	 * @param sql
	 * @param objects 必须和SQL语句中的问号一一对应
	 * @return
	 */
	public ResultSet executeSearch(String sql , Object[] objects) {
		
		con = getConnection();
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			
			if(objects != null) {
				
				for(int i = 0 ; i < objects.length ; i++) {
					pstmt.setObject(i  +  1, objects[i]);
				}
				
			}
			
			rs = pstmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void close(ResultSet rs) {
		close(con, pstmt, rs);;
	}
}
