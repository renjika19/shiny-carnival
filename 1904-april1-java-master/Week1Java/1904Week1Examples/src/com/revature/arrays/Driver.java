package com.revature.arrays;

public class Driver {

	/*
	 * Arrays
	 * an array is a group of like-typed variables that are
	 * referred to by a common name. some thigns to note
	 * about arrays in java include:
	 * 
	 * 		-Arrays are of a fixed size. this means that they
	 * 		are instantiated...So, yes, arrays are in fact objects
	 * 		-Their size cannot change
	 * 		-the size of an array must be specified by an int value
	 * 		and not a long or a short
	 * 		-the variables in an array are ordered and each
	 * 		have and index beginning from 0
	 * 		-you can create multidimensional arrays (arrays
	 * 		inside of arrays)
	 * 		-the length of an array can be found by invoking the
	 * 		'length' member on any array
	 */
	public static void main(String[] args) {
		// Arrays can be declared in one of these two ways:
		int arr[];// valid declaration
		int [] arr2; //valid
		
		// likewise, there are a few ways to instantiate arrays:
		arr = new int[5]; //valid, makes a new array with a capacity of 5
		arr2 = new int[] {1,2,3,4,5}; //also valid
		
		//note that arrays begin counting at 0
		arr[0]=7;
//		System.out.println(arr[0]);
		for(int x: arr) {
			System.out.println(x);
		}
		
		// the length field of all arrays are actually final members
		// (constant, cannot be changed)
		
		String[] things = new String[3];
		things[0] = "um";
		things[1] = "Jugggggggggggernaught";
		things[2] = "post-zero";
		for(String thing: things) {
			System.out.println(thing);
		}
		
		//multidimensional arrays
		int[][] twoD = new int[5][5];
		int[][] twoD2 ={{1,2,3},{1,2,4},{1,2,5}};
		
//		for(int i = 0; i <3;i++) {
//			for(int j = 0; j<3; j++) {
//				System.out.println(twoD2[i][j]);
//			}
//		}
		
		for(int[] intArray: twoD2) {
			for(int y : intArray) {
				System.out.println(y);
			}
		}
		
	}	

}
