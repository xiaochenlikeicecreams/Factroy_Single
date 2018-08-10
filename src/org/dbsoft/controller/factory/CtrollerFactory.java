package org.dbsoft.controller.factory;

import org.dbsoft.controller.dao.AdminCtrollerDao;
import org.dbsoft.controller.dao.PersonCtrollerDao;
import org.dbsoft.controller.dao.impl.AdminController;
import org.dbsoft.controller.dao.impl.PersonController;

public class CtrollerFactory {
	
	private static CtrollerFactory ctrollerFactory = null;
	private  AdminCtrollerDao adminCtrollerDao = null;
	private  PersonCtrollerDao personCtrollerDao = null;
	
	public static CtrollerFactory getCtrollerFactory() {
		if(ctrollerFactory == null) {
			ctrollerFactory = new CtrollerFactory();
		}
		return ctrollerFactory;
	}
	public  AdminCtrollerDao getAdminCtrollerDao() {
		if(adminCtrollerDao == null) {
			adminCtrollerDao = new AdminController();			
		}
		return adminCtrollerDao;
	}
	
	public  PersonCtrollerDao getPersonCtrollerDao() {
		if(personCtrollerDao == null) {
			personCtrollerDao = new PersonController();	
		}
		return personCtrollerDao;
	}
	
	
}
