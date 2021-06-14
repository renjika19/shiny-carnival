package com.revature.varargs;

public class Driver {

	public static void main(String[] args) {
		Driver driver = new Driver();
		System.out.println(driver.sum(10,7));
		System.out.println(driver.sum(10,7,8,9,11,300));
		System.out.println(driver.sum(10));
	}
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public int sum(int a, int b, int c) {
		return a + b + c;
	}
	
	/*
	 * When you use varargs, you are telling the method to
	 * expect a variable number of variables. So in other
	 * words, you can have anywhere between 0 to many variables
	 * It is called varargs, because you have VARiable
	 * ARGuments.
	 * Syntax: type ... name-of-array
	 * The variables are placed inside of an array of the type
	 * that is specified before the '...'
	 */
	
	public int sum(int a, int ... nums) {//varargs must come last
		int result = 0;
		for(int i: nums) {
			result += i;
		}
		return result;
	}

}
