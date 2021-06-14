package com.revature.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllTests.class, ArithmeticTest.class, ArithmeticTest2.class, GenericTest.class })
public class AllTests2 {

}
