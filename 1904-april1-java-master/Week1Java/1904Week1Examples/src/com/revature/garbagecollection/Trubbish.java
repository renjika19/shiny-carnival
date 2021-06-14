package com.revature.garbagecollection;

/*
 * Java does not let you, the developer, handle memory
 * Java takes full control of that itself. This is done
 * using the Garbage Collector. An executioner who
 * serves to only ensure that we don't have any
 * unreachable resources that remain. IE, unreferenced
 * objects sitting around cluttering up memory
 * 
 * Any object in Java is eligible for garbage collection
 * if one of the following criteria is met:
 * 	-reference is reassigned
 * 	-reference is pointing to null
 * 	-Scope of the instance is expired
 */

public class Trubbish {
	public int id;

	public Trubbish(int id) {
		super();
		this.id = id;
		System.out.println("Trash created, ID:" + id);
	}
	
	@Override
		protected void finalize() throws Throwable {
			System.out.println("\t\tTrash ID: " + id
					+ " Collect STARTED");
/*
 * This method does NOTHING for garbage collection
 * (functionally). It is simply the method that is called
 * by the garbage collector prior to actually reclaiming
 * the memory of the particular object.
 */
		}
	
	

}
