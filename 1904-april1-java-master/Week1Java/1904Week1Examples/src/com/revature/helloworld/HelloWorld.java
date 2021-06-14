// package must be first, before any imports or classes
package com.revature.helloworld; // declares which package the class is located in

//next we can import other classes in other packages to use
//import java.lang.*; // actually, we don't need this - everything in java.lang is imported by default!
//the * means everything in that package

//can only have 1 public class per file
//the name of the public class must match the name of the file

public class HelloWorld {
	// to run or execute a file, we need a main method with matching method signature:
		public static void main(String[] args) {
			System.out.println("Hello World!");
		}
		
		// - line comment
		/*
		 *  - multi line comment
		 */
		
		/**
		 * Java doc comment - these will show up when documentation is generated from this source code
		 */

}