package org.dbsoft.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dbsoft.controller.dao.impl.AdminController;
import org.dbsoft.controller.factory.CtrollerFactory;
import org.dbsoft.model.Admin;

public class AdminServer extends HttpServlet{
	private String op = null;
	private String path = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPut(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		op = request.getParameter("op");
		if(op == "adminLogin" || "adminLogin".equals(op)) {
			this.doAdminLogin(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doAdminLogin(HttpServletRequest request, HttpServletResponse response) {
		String adminName = request.getParameter("adminName");
		String adminPassword = request.getParameter("adminPassword");
		Admin admin = new Admin(0, adminName, adminPassword);
		
		admin = CtrollerFactory.getCtrollerFactory().getAdminCtrollerDao().adminLogin(admin);
		if(admin != null) {
			request.getSession().setAttribute("admin", admin);
			path = "/web/persons.jsp";
		}else {
			path = "/web/login.jsp";
		}
	}
}
