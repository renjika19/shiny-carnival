package com.revature.pillars;

public interface AnimalActions {
	/*
	 * Interfaces vs Abstract Classes
	 * -Both can have concrete and abstract methods. However,
	 * interfaces will require the keywords static or default.
	 * -AS well both can NOT be instantiated as a standalone
	 * instance
	 * -Classes can implement as many interfaces as you want
	 * -Classes can extend only one class at most
	 * -Interfaces are typically used for enforcing actions
	 * on the children
	 * -Any child class that implements an interface will
	 * be required to implement actions as opposed to states.
	 */
	
	/*
	 * More on interfaces...
	 * 
	 * All fields will be public, static, and final. regardless
	 * if you include or omit these keywords
	 * 
	 * All methods are public as well as abstract, barring the
	 * use of default or static
	 */
	
	int i =10;
	public String eat();
	public String move();
	
	public static void method() {
		System.out.println("static implementation");
	}
	
	public default void defaultMethod() {
		System.out.println("default implementation");
	}
}
