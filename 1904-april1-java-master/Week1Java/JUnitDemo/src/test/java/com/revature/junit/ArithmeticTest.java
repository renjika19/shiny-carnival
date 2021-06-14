package com.revature.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.Arithmetic.Arithmetic;

public class ArithmeticTest {
	Arithmetic a =null;
	
	@Before
	public void setup() {
		a= new Arithmetic();
	}
	
	@Test
	public void testAddition() {
		assertEquals(30,a.addition(10,5,14,1));
	}
	
	@Test
	public void testSubtract(){
		assertEquals(5, a.subtraction(10,5));
		assertEquals(0, a.subtraction(0));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(0,a.multiplication());
		assertEquals(8,a.multiplication(4,2));
	}
	
	@Test
	public void testDivision() {
		assertEquals(0,a.division());
		assertEquals(4, a.division(40,10));
	}
	
	/*
	 * note that using the expected key/value pair inside of
	 * a test annotation will make it so that the test will
	 * ONLY pass if the exception occurs
	 */
	
	@Test(expected=ArithmeticException.class)
	public void testDivByZero() {
		assertEquals(0,a.division(1,0));
	}
	
	@Ignore //this will omit the specified test from class 
	//completely
	@Test//(expected=NullPointerException.class)
	public void testDivNull() {
		a.division(null);
	}
	
	@Test(timeout=3000)
	public void timeWaster() {
		while(true) {
//			fail();
		}
	}
	@After
	public void tearDown() {
		a =null;
	}
	
	/*
	 * Different asserts:
	 * -assertEquals
	 * -assertNotEquals
	 * -assertTrue
	 * -assertFalse
	 * -assertNull
	 * -assertNotNull
	 * -assertArrayEquals
	 * 
	 */

}
