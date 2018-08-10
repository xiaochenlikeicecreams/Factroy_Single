package org.dbsoft.model;

public class Person {

	private int personId;
	private String personName;
	private String personEmail;
	private String personSex;
	private String personPassword;
	
	public Person() {
		
	}
	
	

	public Person(int personId, String personName, String personEmail, String personSex, String personPassword) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personEmail = personEmail;
		this.personSex = personSex;
		this.personPassword = personPassword;
	}
	
	public Person( String personName, String personEmail, String personSex, String personPassword) {
		super();
		this.personName = personName;
		this.personEmail = personEmail;
		this.personSex = personSex;
		this.personPassword = personPassword;
	}
	
	



	public Person(String personEmail, String personPassword) {
		super();
		this.personEmail = personEmail;
		this.personPassword = personPassword;
	}



	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getPersonPassword() {
		return personPassword;
	}

	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	
	
}
