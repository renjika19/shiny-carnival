package com.revature.services;

import com.revature.beans.Owner;
import com.revature.dao.OwnerDao;
import com.revature.dao.OwnerDaoImpl;

public class OwnerService {
	public boolean confirmLogin(String username, String password) {
		OwnerDao od = new OwnerDaoImpl();
		Owner own = null;
		
		if((own=od.selectOwnerByUsername(username.toLowerCase()))!=null){
			if(own.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean usernameExists(String username) {
		if(new OwnerDaoImpl().selectOwnerByUsername(username)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean registerUser(String username, String password, 
			String name) {
		if(new OwnerDaoImpl().insertOwner(new Owner(name,null,username,password))) {
			return true;
		}
		return false;
	}
}
