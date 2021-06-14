package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		/*
		 * A string is an array of character.
		 * By default, strings are immutable.
		 * this means that you can NOT change the contents of
		 * a string
		 * they are final
		 */
		
		String s1 = "beisbol";
		System.out.println("s1: " + System.identityHashCode(s1));
		s1 = s1+" ball";
		System.out.println("s1: " + System.identityHashCode(s1));
		
		System.out.println(s1);
		
		System.out.println("==========");
		String s2 = "socker";
		String s3 = "socker";
		System.out.println("s2: " + System.identityHashCode(s2));
		System.out.println("s3: " + System.identityHashCode(s3));
		
		System.out.println(s2==s3);
		s2+="s"; //note this is the same as s2=s2+"s"
		s3+="s";
		System.out.println(s2==s3);
		s2=s2.intern();//points to, or creates then points to
		//reference inside of string pool
		s3=s3.intern();
		System.out.println(s2==s3);		
		
		/*
		 * String builder and StringBuffer
		 * -Both of these classes allow us to make mutable strings
		 * -they wrap around the string class and allow us
		 * -to create strings that, when changed, do not require
		 * -the creation of a new STring object to hold the new
		 * value
		 * -So.... what's the difference between String, StringBuilder
		 * and StringBuffer?
		 * -Strings are immutable. every time you make a new string,
		 * the reference will point to a new place in memory
		 * -StringBuffer and StringBuild are mutable
		 * 
		 * StringBuffer and StringBuilder allow us to make strings that
		 * we are able to change. In addition, the core difference
		 * between these two is that string builder is NOT thread safe,
		 * whereas String Buffer is thread safe (synchronized).
		 */
		
		System.out.println("==============Builder/Buffer");
		StringBuilder sbui =new StringBuilder("Stuff");
		System.out.println(sbui);
		System.out.println(System.identityHashCode(sbui));
		sbui.append(" and things");
		System.out.println(sbui);
		System.out.println(System.identityHashCode(sbui));
	}

}
