package com.revature.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("stuff");
		list.add("more...stuff...");
		list.add("and things");
		System.out.println(list);
		list.sort(null);
		System.out.println(list);
		
		List<Person> plist = Arrays.asList(
				new Person("John Smith", 27),
				new Person("Juan Sanchez", 99),
				new Person("My name is...JEFF",22),
				new Person("Mario",50)
				); // creates and populates list
//		note, this list is immutable this way
		for(Person p:plist) {
			System.out.println(p);
		}
//		plist.add(new Person("Me",1000)); gives exception
		plist.sort(null); // uses object's comparator method
		System.out.println("==AFFTER SORTING==");
		for(Person p: plist) {
			System.out.println(p);
		}
		
		System.out.println("====COMPARATORS====");
		plist.sort(new PersonNameComparator());
		for(Person p: plist) {
			System.out.println(p);
		}
	}

}
