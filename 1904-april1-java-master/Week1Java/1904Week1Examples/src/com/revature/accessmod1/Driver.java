package com.revature.accessmod1;

public class Driver {
/*
 * class vs oject
 * 
 * a class represents the blueprints for an object
 * when an object is created, it is based off of the class
 * in which you used for its creation
 * 
 * An Object is simply an instantiated class. It is given
 * allocated memory for its existance
 */
	
	public static void main(String[] args) {
		Modifiers mod = new Modifiers();
		//Datatype variablename = new Classname();
		//Reference = Assignment
		
		System.out.println("===========ACCESSING FIELDS DIRECTLY============");
		System.out.println(mod.pub); //public
		System.out.println(mod.prot); //same package, so ok
		System.out.println(mod.def); // same package, so ok
//		System.out.println(mod.priv); //not same class, not ok
		
		System.out.println("===EXECUTING OUTPUT() FROM MODIFIERS====");
		mod.output();
	}

}
