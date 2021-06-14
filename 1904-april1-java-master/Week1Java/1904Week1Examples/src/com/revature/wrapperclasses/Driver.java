package com.revature.wrapperclasses;

public class Driver {
	/*
	 * Primitive datatypes (all Eight) are NOT objects
	 * However, if this lack of Object-ness leaves a hole
	 * in your heart, well.... there is some good news!
	 * 
	 * Java provides Wrapper Classes, which are Object
	 * representations of the primitive datatypes.
	 * 
	 * To access them, simply write the datatype in its
	 * full name and preceded with a capital letter
	 */
	
//	int i = 9;
	Integer i;
	Integer i2 = new Integer(9);
	Double d;
	Character c;
	Boolean bool;
	//etc
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.printValues();

	}
	
	public void printValues() {
		System.out.println(i);
		i = 7; //this is an example of autoboxing
		System.out.println(i);
		

		Integer i3 = Integer.MAX_VALUE; // you can do the same
//									with other wrapper classes
//		System.out.println(i3);
//		System.out.println(Float.MAX_VALUE);
		System.out.println(addition(5, 6));
		System.out.println(addition2());
	}
	/*
	 * Autoboxing vs Auto-unboxing
	 * -Anytime that you come across a method/exection that
	 * requires a Wrapper Class as an input (anytime that
	 * you need an Object as an input, but you provided a
	 * primitive)
	 * -if you provide a primitive value, it will implicitly
	 * wrap the primitive into its Wrapper Class without you
	 * having to explicitly do so
	 * -this conversion is called "autoboxing"
	 * 
	 * vice versa, if you pass a Wrapper class to a function
	 * requiring a primitive value, it will unwrap the class
	 * into its primitive for use in the function/method
	 */
	
	//autoboxing: primitive -> object
	//auto-unboxing: object -> primitive
	
//	note that there are some other utility members that are
//	provided to us by each of the wrapper classes
	public Integer addition(int a, int b) {
//		return new Integer(a.intValue() + b);
		return a+b;
		// note that this is "the same" as
		// return a.intValue + b
	}
	
	public int addition2() {
		return new Integer(5);
	}
}
