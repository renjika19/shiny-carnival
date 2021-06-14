package com.revature.pillars;

public class Driver {

	public static void main(String[] args) {
		covariance();

	}
	
	public static void covariance() {
		A a = new A();
		B b = new B();
		C c = new C();
		System.out.println("=====START=====");
//		System.out.println(a.field);
//		System.out.println(b.field);
//		System.out.println(c.field);
//		a.method1();
//		b.method1();
//		c.method1();
		
		A a2 = new C();
		
		//Remember that you get the reference's version
		// of the field
//		System.out.println(a2.field);
//		System.out.println(a2.field2);
//		note that you cannot access fields that your
//		reference does not have
//		a2.method1();
		
//		System.out.println("========");
//		a = b;
//		a.method1();
//		System.out.println(a.field);
		a2.method1();
		System.out.println("=====END=====");
	}

}
