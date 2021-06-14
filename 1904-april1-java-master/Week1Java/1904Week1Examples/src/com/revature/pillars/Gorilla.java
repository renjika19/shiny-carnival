package com.revature.pillars;

public class Gorilla extends Animal implements AnimalActions{
	/*
	 * The fact that the Gorilla extends Animal means that
	 * one can say: "A Gorilla IS an Animal"
	 * 
	 * The fact that the Gorilla has a filed with the object
	 * arm means that one can say: "A Gorilla HAS an Arm"
	 */
	
	private int teeth;
	private Arm leftArm;
	private Arm RightArm;
	
	
	@Override
	public int getTeeth() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String eat() {
		return "Gorilla is having lunch";
	}
	
	/*
	 * Below we have 'Override' preceded by an 'at' symbol
	 * @. This is called an annotation. It provides metadata
	 * and additional checks for Java applications. In
	 * the case of @Override, it tells us that the below
	 * implementation is changing existing methods that
	 * were inherited. It is an optional annotation. However
	 * it does provide additional assurance that we are
	 * indeed overriding something, and not simply making
	 * a new method that perhaps might be misspelled.
	 */

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Overloading
	 * 
	 * Any time that you use the same method name in
	 * a class repeatedly with different count/types,
	 * you overload the method. This means which method
	 * that is called is determined by what you pass into
	 * it.
	 */
	public Gorilla(int teeth, Arm leftArm, Arm rightArm) {
		super();
		this.teeth = teeth;
		this.leftArm = leftArm;
		RightArm = rightArm;
	}


	public Gorilla() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Arm getLeftArm() {
		return leftArm;
	}


	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}


	public Arm getRightArm() {
		return RightArm;
	}


	public void setRightArm(Arm rightArm) {
		RightArm = rightArm;
	}


	public void setTeeth(int teeth) {
		this.teeth = teeth;
	}


	@Override
	public String toString() {
		return "Gorilla [teeth=" + teeth + ", leftArm=" + leftArm + ", RightArm=" + RightArm + "]";
	}
	
}
