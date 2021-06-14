package com.revature.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/*
 * a test suite is a collection of test cases
 * a test case is a collection of test steps for testing
 * a specific feature
 */
@RunWith(Suite.class)
@SuiteClasses({ ArithmeticTest.class, ArithmeticTest2.class, GenericTest.class })
public class AllTests {

}
