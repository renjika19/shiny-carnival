package com.revature.main;

import com.revature.beans.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.PolkamanService;

public class Driver {

	public static void main(String[] args) {
		System.out.println("====START====");
		PolkamanService ps = new PolkamanService();
//		>>>>Add Polka
//		ps.addNewPolkaman(
//				new Polkaman(777, "Vine-o-Saurus", 150,150,2)
//				);
//		>>>>Get by id
//		System.out.println(ps.getPolkamansById(2));
//		>>>>Delete by id
//		ps.deletePolkamanById(1);
//		>>>>Get all Polka
//		List<Polkaman> ps1 = ps.getAllPolkamans();
//		for(Polkaman p: ps1) {
//			System.out.println(p);
//		}
		
		
		
		EmployeeService es = new EmployeeService();
		es.insertEmployeeSP(
				new Employee(
				"Jerrrrrrry",
				5,
				"Work"
				));
		System.out.println("====END====");

	}

}
