package com.revature.pillars;
/*
 * ABSTRACT CLASSES
 * -When applied to a class, means that the class may
 * NEVER be instantiated. This allows us to provide
 * methods with implementations as well as signatures
 * only. (Abstract methods)
 * 
 * The purpose of an abstract class is to provide a class
 * that you want all the children to inherit from and
 * guarantee that they share these methods
 */
public abstract class Animal {
	//Abstract Method
	public abstract int getTeeth();
	public boolean isAlive() {
		return true;
	}
}
