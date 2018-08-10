package org.dbsoft.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dbsoft.controller.dao.impl.PersonController;
import org.dbsoft.controller.factory.CtrollerFactory;
import org.dbsoft.model.Person;

public class PersonServer extends HttpServlet {
	private String op = null;
	private String path = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		op = request.getParameter("op");
		if(op == "regist" || "regist".equals(op)) {
			this.doRegist(request, response);
		}else if(op == "login" || "login".equals(op)) {
			this.doLogin(request, response);
		}else if(op == "show" || "show".equals(op)) {
			this.doShow(request, response);
		}else if(op == "update" || "update".equals(op)) {
			this.doUpdate(request, response);
		}else if(op == "showPersons" || "showPersons".equals(op)) {
			this.doShowPersons(request, response);
		}else if(op == "del" || "del".equals(op)) {
			this.doPersonDelete(request, response);
		}
		System.out.println(path);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("================================>>");
		String personEmail = request.getParameter("personEmail");
		String personPassword = request.getParameter("personPassword");
	
		Person person = new Person( personEmail,  personPassword);
		
		person = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personLogin(person);
		String toPath = null;
		if(person != null){
			int personId = person.getPersonId();
			String personName = person.getPersonName();
			String personSex = person.getPersonSex();	
			person = new Person(personId, personName, personEmail, personSex, personPassword);
			request.getSession().setAttribute("person", person);
			 path = "/web/show.jsp";
		}else{
			 path = "/web/login.jsp";
		}
		
	}
	
	public void doRegist(HttpServletRequest request, HttpServletResponse response) {
		String personName = request.getParameter("personName");
		String personEmail = request.getParameter("personEmail");
		String personPassword = request.getParameter("personPassword");
		String personSex = request.getParameter("personSex");
		
		Person person = new Person( personName, personEmail, personSex, personPassword);

	
		boolean b = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personRegist(person);
		if(b){
			path = "/web/login.jsp";
		}else{
			path = "/web/regist.jsp";
		}
		
	}
	
	public void doShow(HttpServletRequest request, HttpServletResponse response) {
		int personId = Integer.parseInt(request.getParameter("personId"));
		Person person = new Person();
		person.setPersonId(personId);
		
		person = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personSearch(personId);
		if(person != null) {
			System.out.println("==================..");
			request.setAttribute("person", person);
		}
		path = "/web/update.jsp";
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) {
		String personName = request.getParameter("personName");
		String personEmail = request.getParameter("personEmail");
		String personPassword = request.getParameter("personPassword");
		String personSex = request.getParameter("personSex");
		int personId = Integer.parseInt(request.getParameter("personId"));
		
		Person person = new Person( personId,personName, personEmail, personSex, personPassword);

	
		boolean b = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personUpdate(person);
		if(b){
			path = "/web/login.jsp";
		}else{
			path = "/web/show-op.jsp?personId="+personId;
		}
		
	}
	
	public void doShowPersons(HttpServletRequest request, HttpServletResponse response) {
		
		List<Person> persons = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personList();
		request.setAttribute("persons", persons);
		path = "/web/persons.jsp";
	}
	
	public void doPersonDelete(HttpServletRequest request, HttpServletResponse response) {
		
		int personId = Integer.parseInt(request.getParameter("personId"));
		Person person = new Person();
		person.setPersonId(personId);
		boolean b = CtrollerFactory.getCtrollerFactory().getPersonCtrollerDao().personDelete(person);
		if(b) {
			path = "/ps?op=showPersons";
		}else {
			path = "/web/login.jsp";
		}
	}
	
}
