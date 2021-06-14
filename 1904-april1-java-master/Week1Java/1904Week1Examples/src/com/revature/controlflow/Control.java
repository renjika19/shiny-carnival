package com.revature.controlflow;

import java.util.Scanner;

public class Control {
	public static void main(String[] args) {
//		control1();
//		enhanced();
//		ternary();
//		shortCircuit();
//		breakControl();
		switchStatement();
	}
	
	public static void control1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value: ");
		int x = scan.nextInt();
		
//		if statements
//		if(x>3) {
//			System.out.println("x is greater than 3");
//		}else if(x == 3) {
//			System.out.println("x is exactly 3");
//		}else {
//			System.out.println("x is obviously less than 3...");
//		}
//		for loops
//		for (int i = 0; i<x; i++) {
//			System.out.println(i);
//		}
		
//		while loops
//		int i =0;
//		while(i<x) {
//			System.out.println(i);
//			i++;
//		}
		
//		do-while loop
		int i =0;
		do {
			System.out.println(i);
			i++;
		}while(i<x);
	}
	
	public static void enhanced() {
		String[] arr = {"string1","string2","string3"};
		for(String str: arr) {
			System.out.println(str);
		}
		//for loop below is the same as for loop above (funcitonally)
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
			
		}
	}
	
	public static void ternary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value:");
		int x = scan.nextInt();
		
		String s = x>3 ? "x is greater than 3":"x is not greater than 3";
		System.out.println(s);
	}
	
	public static void shortCircuit() {
		int x = 6;
		int y = 6;
		int z =7;
		System.out.println("x="+x+",y="+y+",z="+z);
		if(x==y | y==z) {//"or" is denoted by: |
			System.out.println("Or: true");
		}if(x==y & y==z) {//"and" is denoted by: &
			System.out.println("And: true");
		}
		
		// you can also use || or &&
		// if you use the "double version", it is indicating
		//you are intending for this control flow statement
		//to "short circuit"
		if(x==y && x==y++) {
			System.out.println("x="+x+",y="+y+",z="+z);
		}
		//fun fact: you can use short circuiting to avoid null
		// pointer exceptions. if you first check to see if the
		//object is null, before applying a certain operation
		//if (obj != null && obj.equals(something){}	
		
	}
	
	public static void breakControl() {
		//labels, break, continue
//		for (int i=0;i<10;i++) {
//			System.out.println(i);
//			if(i==5) {
//				continue;
//			}
//			System.out.println(i);
//			if(i==7) {
//				break;
//			}
//		}
		loop1: for(int i = 0; i<10; i++) {
			loop2: for(int j=0; j<5;j++) {
				if(i==7 && j >3) {
					break loop1;
				}
				System.out.println(i + " " + j);
			}
		}	
	}
	
	public static void switchStatement() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Gimme a number");
		int x = scan.nextInt();
		boolean bool =true;
		// switch statements do not take input of a tye 'boolean'
		//they take, ints, shorts, etc.
		switch(x) {
		case 0: System.out.println("x is 0"); break; 
		case 1: System.out.println("x is 1");break;
		case 2: System.out.println("x is 2"); break;
		default: System.out.println("default");break;
		}
	}
}
