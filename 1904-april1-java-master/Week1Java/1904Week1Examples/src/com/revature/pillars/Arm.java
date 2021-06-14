package com.revature.pillars;
/*
 * BEANS
 * -beans are a design pattern that, like the pojo, aims to
 * represent data and state
 * -the difference between the two is that Beans follows
 * a strict naming convention
 * 		-ALL getters and setters must be named
 * 		getVarName/setVarName
 * 		-ALL beans MUST have a no args constructor
 * 		-ALL beans should override toString()
 * 		-Boolean fields ought to follow the isVariable()
 * 		convention
 * -The reason for these restrictions is that there exisits
 * frameworks that assume the names of your getters and setters
 * so that it can connect and use them for you. As well as
 * create instances of these beans without you having to do
 * so. This process requires the use of the no args
 * constructor. (Foreshadowing to week 6)
 */
public class Arm {
	private int length;

	public Arm() {
		super();
	}
	
	public Arm(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Arm [length=" + length + "]";
	}
	
	
}
