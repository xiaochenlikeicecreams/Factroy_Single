package org.dbsoft.controller.dao;

import java.util.List;

import org.dbsoft.model.Person;

public interface PersonCtrollerDao {

	public boolean personRegist(Person person);
	
	public Person personLogin(Person person);
	
	public Person personSearch(int personId);
	
	public boolean personUpdate(Person person);
	
	public List<Person> personList();
	
	public boolean personDelete(Person person);
	
}
