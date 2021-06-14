package com.revature.scopes;

public class Driver {

	public static void main(String[] args) {
		Scopes scopes = new Scopes("hello","world");
		System.out.println(scopes.count);
		
		Scopes scopes2 = new Scopes();
		System.out.println(scopes2.count);
		System.out.println(Scopes.count);
		System.out.println(scopes);
		System.out.println(scopes2);

	}

}
