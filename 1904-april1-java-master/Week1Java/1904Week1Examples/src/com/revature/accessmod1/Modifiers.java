package com.revature.accessmod1;

public class Modifiers {
/*
 * There are two kinds of 'modifiers' available in Java. One
 * of the two are called 'access modifiers', whereas the other
 * is called 'non access modifiers'.
 * Available 'Access Modifiers' include:
 * 
 * -Private
 * 	-restricts access to the entity to only within the class in
 * which it exists
 * 	- for example.... you cannot access a private entity from
 * outside of its class
 * -Default
 * 	-restricts access to only the classes that are within the
 * same package as this class.
 * -Protected
 * 	-protected is restricted to only classes that are within the
 * same package or classes that inherit from this class
 * specifically
 * 	-so if there is a class, that is not in the same package as this one,
 * but inherits from it, it will still have access
 * -public
 * 	-accessible from anywhere in the project
 * 
 * NON ACCESS MODIFIERS:
 * -Static
 * 	-Sets the resource to be available without needing to
 * instantiate them
 * 	-any static fileds are shared among all instances of the
 * class
 * 	-for example: there can only be one isntance of whatever
 * it is that you made static
 * -Final
 * 	-make fileds constant. you cannot change or reassigne
 * the filed value
 * 	-makes methods impossible to override
 * 	-makes classes uninheritable
 * -Abstract
 * 	-foregoes the requirement to provide a body for a method name
 * 	-instead, it requires any non abstract class that inherits
 * the method to provide the body instead
 * 	-when attached to a class, you can NOT instantiate the class
 * -Transient
 * 	-prevents the resource from being serialized.
 * -Synchronized
 * 	-limits the amount of threads that can access a resource at
 * a given time to only ONE
 * -Default (as in the actual key word... not the access mod)
 * 	-Brought to us in Java 8. It is a way of allowing you to
 * provide a body for abstract methods
 * 	-specifically used in interfaces
 * -Strictfp
 * 	-if it is on a class, all methods are strictfp
 * 	-this ensures that all floating points are configured to
 * follow IEEE standards
 * -Volatile
 * 	-a volitle variable must be accessed via main memory.
 * This means that all threads will be able to access this
 * specific variable, regardless if local or not.
 * -Native
 * 	-implementations of a method that will NOT be written in
 * Java. It will be written in some other language.
 */
	public String pub = "Public";
	protected String prot = "Protected";
	String def = "Default"; //default
	private String priv = "Private";
	public static String stat = "static";
	public void output() {
		System.out.println(pub);
		System.out.println(prot);
		System.out.println(def);
		System.out.println(priv);
	}
	
}
