package com.revature.constructors;

public class C extends B{
	private int myNumber;
	public C() {
		System.out.println("Printing from inside C's no-arg constructor");
	}
	
	public C(int myNumber) {
		super(myNumber);
		System.out.println("Inside the 1-arg constructor of C");
		this.myNumber = myNumber;
	}
	
	public static void myHiddenMethod() {
		System.out.println("This is class C's Hidden Method");
	}
	
	public static void main(String[] args) {
		A a = new A(10);
		A.myHiddenMethod();
		System.out.println();
		System.out.println("When constructor B is invoked, it"
				+ "calls the constructor for A");
		B b = new B(11);
		System.out.println("When constructor C is invoked, it"
			+ "calls the constructor for B"
			+ "call the constructor for A");
		C c = new C(12);
	}
}
