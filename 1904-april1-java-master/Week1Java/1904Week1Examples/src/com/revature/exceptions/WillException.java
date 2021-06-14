package com.revature.exceptions;

public class WillException extends Exception{
//note that this does not inherit from RuntimeException
//	so it is a checked exception
	public String getMessage() {
		return "William's Exception...";
	}
}
