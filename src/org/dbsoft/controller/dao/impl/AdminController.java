package org.dbsoft.controller.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dbsoft.controller.dao.AdminCtrollerDao;
import org.dbsoft.model.Admin;
import org.dbsoft.utils.ExecuteCRUD;

public class AdminController extends ExecuteCRUD implements AdminCtrollerDao {

	private String sql = null;

	public Admin adminLogin(Admin admin) {
		sql = "select * from admin where adminName = ? and adminPassword = ?";
		String adminName = admin.getAdminName();
		String adminPassword = admin.getAdminPassword();

		Object[] objects = { adminName, adminPassword };
		ResultSet rs = executeSearch(sql, objects);
		try {
			if (rs.next()) {
				int adminId = rs.getInt("adminId");
				admin = new Admin(adminId, adminName, adminPassword);
			} else {
				admin = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return admin;
	}

}
