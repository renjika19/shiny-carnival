package com.revature.accessmod2;

import com.revature.accessmod1.Modifiers;

public class Driver extends Modifiers{

	public static void main(String[] args) {
		
		Modifiers mod = new Modifiers();
		System.out.println("==ACCESSING FIELDS===");
		System.out.println(mod.pub);
		System.out.println(Modifiers.stat);
//		System.out.println(mod.def); //different package, not ok
//		System.out.println(mod.priv);// different class, not ok
		
		Driver driver = new Driver();
		System.out.println(driver.pub);
		System.out.println(driver.prot);// child class, so ok
	}

}
