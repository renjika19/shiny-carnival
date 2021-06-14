package com.revature.constructors;

public class A {
	
	private int myNumber;
	/*
	 * if we do not declare any constructors, the compiler will give us the default
	 * no-arg constructor... for free!
	 */
	public A() {
//		super(); the call to super() is implicit
//		this() is the alternatvie to super()
		System.out.println("Printing from A's no-arg constructor");
	}
	
	//below is a constructor that takes one argument
	public A(int i){
		System.out.println("Inside the 1-arg constructor for A");
		this.myNumber = i;
	}
	
	public static void myHiddenMethod() {
		System.out.println("This is class A's hidden method");
	}
}
