package com.revature.junit;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericTest {
	/*
	 * JUnit is a java unit testing tool.
	 * Unit testing is the most micro level of testing where
	 * we take the individual methods and components and
	 * execute them to ensure we are getting the expected
	 * output
	 * Typically these tests are run before you deploy your code
	 * They will usually run on the compiled code itself. So,
	 * require deployment is not necessary
	 */
	
	
	/*
	 * Before class will be the first method called regardless
	 * of others. This method should be used to prepare the
	 * global test environment. (Such as setting up constants
	 * for your test)
	 */
	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("BEFORE CLASS");
		
	}
	
	/*
	 * similarly, after class will be executed last. It
	 * should be used to clean up test data if any were created.
	 * 
	 */
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("AFTER CLASS");
	}
	
	/*
	 * Before is executed before every test case (or every
	 * test annotation). It should be used to reset instances
	 * that are used each test 
	 */
	@Before
	public void setUp() {
		System.out.println("BEFORE");
	}
	
	/*
	 * After is executed after each individual test or test
	 * annotation. It should be used for cleaning instances
	 * that were used prior to tests
	 */
	@After
	public void tearDown() {
		System.out.println("AFTER");
	}
	
	/*
	 * The Test annotation is the actual test case and should
	 * either pass or fail. the total result summary is based
	 * off of the amount of @Test you have in your class
	 * 
	 */
	
	@Test
	public void test1() {
		System.out.println("Test1");
		fail("not yet implemented");
	}	
	@Test
	public void test2() {
		System.out.println("Test2");
		fail("not yet implemented");
	}	
	@Test
	public void test3() {
		System.out.println("Test3");
		fail("not yet implemented");
	}
}
