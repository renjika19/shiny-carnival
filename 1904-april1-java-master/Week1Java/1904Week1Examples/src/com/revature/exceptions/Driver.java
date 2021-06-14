package com.revature.exceptions;

import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		System.out.println("=======START=====");
		Driver driver = new Driver();
//		driver.divideByZero();
//		driver.divideByZeroHandled();
//		driver.checkedException();
		System.out.println(driver.somethingWeird());
		System.out.println("=======END=====");

	}
	public void divideByZero() {
		System.out.println(1/0);
	}
	
	public void divideByZeroHandled() {
		/*
		 * An exception is safely described as an incident
		 * where something unexpected occurs.
		 * the application behaves in a manner in which
		 * it should not
		 * 
		 * Note that an exception is not an error.
		 * an error is described as an incident that cannot
		 * be reasonably recovered from
		 */
		
		try {
			//place code here that may be suspect to cause
			//an exception
//			System.out.println(1/0);
			throw new ArithmeticException(); // using the 
//			throw keyword basically ensures that an exception
//			is thrown
		}
		catch(ArithmeticException e){
			//place code in here to describe execution in
			//case of an exception
			//this code will execute instead of the system
			//crashing due to the exception
			
			e.printStackTrace();
			System.out.println("Got EEEEM!");
		}
		finally {
			/*
			 * this block will ALWAYS execute
			 * if the exception does not occur...
			 * this block will execute
			 * if the exception does occur...
			 * this block will execute
			 * if an exception, occurs that you did not 
			 * happen to catch properly, and the app crashes...
			 * this block will still execute
			 * Finally WILL OCCUR
			 * you cannot stop finally except for only two
			 * situations
			 * -you invoke System.exit(0)
			 * -if an error occurs
			 */
			System.out.println("Finally executed");
		}
	}
	public void checkedException(){
		/*you can use throw to trigger an exception of your
		 * choice!
		 * either for custom exceptions, or even testing
		 * purposes
		 * 
		 * Checked exceptions (any exceptions that do not
		 * inherit from RunitmeException) are exceptions
		 * the compiler will look for during compile time.
		 * Should it find any risky code that risks  a checked
		 * exception, an error will be shown until you handle
		 * the risky code. By 'error' i mean the read squiggly
		 * line under the code segment.
		 * Unchecked exceptions do not REQUIRE you to handle
		 * them
		 */
		
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void method1() throws WillException{
		method2();
	}
	public void method2() throws WillException{
		method3();
	}
	public void method3() throws WillException{
		throw new WillException();
	}
	
	public String somethingWeird() {
		try {
			System.out.println(1/0);
			return "TRY";
		}catch(Exception e) {
			//note that while this is valid,
			//it is good practice to catch the most
			//specific type of exception
			return "CATCH";
		}finally {
			return "FINALLY";
		}
	}
	
	public void goodHandling() {
		/*
		 * with multiple try/catch blocks, you need
		 * to order the catches from most specific
		 * to least specific
		 * or... more to the point, never have a parent
		 * exception precede a child
		 * 
		 */
		try {
			
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch(RuntimeException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}catch(Throwable e) {
			//this catch will catch everything that
			//descends from throwable
		}
	}
	
}
