package com.revature.services;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class EmployeeService {
	private EmployeeDao ed = null;
	
	public Boolean insertEmployeeSP(Employee emp) {
		ed = new EmployeeDaoImpl();
		return ed.insertIntoEmployee(emp);
	}
}
