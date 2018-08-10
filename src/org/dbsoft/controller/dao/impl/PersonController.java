package org.dbsoft.controller.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbsoft.controller.dao.PersonCtrollerDao;
import org.dbsoft.model.Person;
import org.dbsoft.utils.ExecuteCRUD;

public class PersonController extends ExecuteCRUD implements PersonCtrollerDao{

	private String sql = null;

	public boolean personRegist(Person person) {
		boolean b = false;
		sql = "insert into person (personName,personEmail,personSex,personPassword) value (?,?,?,?)";
		String personName = person.getPersonName();
		String personEmail = person.getPersonEmail();
		String personSex = person.getPersonSex();
		String personPassword = person.getPersonPassword();
		
		Object[] objects = {personName,personEmail,personSex,personPassword};
		b = executeCreateAndUpdateAndDelete(sql, objects);
		return b;
	}

	public Person personLogin(Person person) {
		sql = "select * from person where personEmail = ? and personPassword = ?";
		String personEmail = person.getPersonEmail();
		String personPassword = person.getPersonPassword();
		Object[] objects = {personEmail,personPassword};
		ResultSet rs = executeSearch(sql, objects);
		try {
			if(rs.next()) {
				int personId = rs.getInt("personId");
				String personName = rs.getString("personName");
				String personSex = rs.getString("personSex");
				person = new Person(personId, personName, personEmail, personSex, personPassword);
			}else {
				person = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return person;
	}
	
	public Person personSearch(int personId) {
		Person person = null;
		sql = "select * from person where personId = ?";
		Object[] objects = {personId};
		ResultSet rs = executeSearch(sql, objects);
		try {
			if(rs.next()) {
				String personName = rs.getString("personName");
				String personSex = rs.getString("personSex");
				String personEmail = rs.getString("personEmail");
				String personPassword = rs.getString("personPassword");
				person = new Person(personId, personName, personEmail, personSex, personPassword);
			}else {
				person = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return person;
	}
	
	public boolean personUpdate(Person person) {
		boolean b = false;
		sql = "update person set personName = ? ,personSex = ? ,personPassword = ? where personId = ?";
		String personName = person.getPersonName();
		String personEmail = person.getPersonEmail();
		String personSex = person.getPersonSex();
		String personPassword = person.getPersonPassword();
		int personId = person.getPersonId();
		
		Object[] objects = {personName,personSex,personPassword , personId};
		b = executeCreateAndUpdateAndDelete(sql, objects);
		return b;
	}
	
	public List<Person> personList(){
		List<Person> persons = new ArrayList<Person>();
		sql = "select * from person";
		ResultSet rs = executeSearch(sql, null);
		try {
			while(rs.next()) {
				int personId = rs.getInt("personId");
				String personEmail = rs.getString("personEmail");
				String personName = rs.getString("personName");
				String personSex = rs.getString("personSex");
				String personPassword = rs.getString("personPassword");
				Person person = new Person(personId, personName, personEmail, personSex, personPassword);
				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return persons;
	}
	
	public boolean personDelete(Person person) {
		int personId = person.getPersonId();
		sql = "delete from person where personId = ?";
		Object[] objects = {personId};
		boolean b = executeCreateAndUpdateAndDelete(sql, objects);
		return b;
	}
}
