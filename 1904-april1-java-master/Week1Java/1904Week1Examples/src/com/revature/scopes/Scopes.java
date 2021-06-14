package com.revature.scopes;
//Design patterns
/*
 * a design pattern is a tried and true approach/methodology
 * for achieving a design functionality or structure in programming
 * Arguably considered to be the "best" way of going about
 * a particular task.
 */

//POJO
/*
 * Plain ol' Java Object
 * a POJO is a design pattern that aims to simply create a class
 * that serve to contain and provide data. Typically it provides
 * no additional functionality. It retains states
 */

public class Scopes {
	public static int count =0;
	/*
	 * Static Scope:
	 * static is the most available scope that you can give
	 * to an entity. anything static is created upon starting
	 * the application. it is destroyed when the app is terminated.
	 * The entity is available for the full lifecycle of a
	 * running application
	 */
	
	private String brand;
	private String type;
	/*
	 * Instance Scope:
	 * Any field within the class, but outside of any methods
	 * is considered to be part of the Instance Scope. This means
	 * that the field is created when the object is instantiated.
	 * It is destroyed when the object is destroyed.
	 */
	
	public Scopes(String brand, String type) {
		this.brand =brand;
		this.type = type;
		count++;
	}
	
	public Scopes() {
		brand ="Unknown";
		type = "Unknown";
		count++;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Scopes [brand=" + brand + ", type=" + type + "]";
	}

	/*
	 * Pass by value:
	 * when you call a method and give it input, that input is
	 * NOT passed into the method. Instead, a copy of the value
	 * that you are inputting is made and created within the method
	 * itself for use.
	 * 
	 * Pass by reference:
	 * You can pass the location of memory to a function and
	 * whatever changes occur to that location of memory is 
	 * automatically represented outside of the function with no
	 * need to return the modified data.
	 */
	
	public void randomMethod(int input) {
		int i = 9;
		/*
		 * Method Scope
		 * Any variables created within a method, can only
		 * be accessed within the method it was created in.
		 * once the method is finished, the fields of the method
		 * are destroyed
		 */
		
		for(int j = 0; j<0;j++) {
			/*
			 * loop scope
			 * field 'j' is only accessible within this loop
			 * and once the loop finishes, 'j' will be destroyed
			 */
			System.out.println(i);
		}
	}
	
	
	
	
	
}
