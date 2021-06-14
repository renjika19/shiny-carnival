package com.revature.equals;

import com.revature.comparing.Person;

public class Driver {

	public static void main(String[] args) {
		Person p1 = new Person("Mary Sue", 18);
		Person p2 = new Person("Marty Stu", 142478);
		Person p3 = new Person("Marylin", 80);
		Person p4 = new Person("Gertrude", 1000);
		Person p5 = new Person("Zelda", 50);
		Person p6 = new Person("Zelda", 50);

		System.out.println(p1==p2); //== makes
//		judgement based off of location in memory
		System.out.println(p1.equals(p2));
//		.equals judges based off of value
		System.out.println(p5==p6);
		System.out.println(p5.equals(p6));

	}

}
