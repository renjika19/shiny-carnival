package com.revature.lambda;

public class Driver {
	/*
	 * Lambda expression are a shorthadn for 
	 * creating anonymous methods
	 * 
	 * added in java 8 and give you the 
	 * following benefits:
	 * -you now have the ability to treat
	 * functionality as a method argument
	 * -a funciton can be created without
	 * belonging to any class
	 * -a lambda expression can be passed around
	 * as if it was an object
	 */
	public static void main(String[] args) {
		FunkyInterface add5 = (num) -> {return num+=5;};
		System.out.println(add5.doMath(20));
		
		// note that you can create several
//		instances of the functional interface
//		in order to create more than one type
//		of anonymous method

	}

}
