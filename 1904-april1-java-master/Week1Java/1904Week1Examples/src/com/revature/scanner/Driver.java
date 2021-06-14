package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		System.out.println("======START=====");
		/*
		 * Scanner is a class used to parse strings/streams
		 * for example: parse nubmers/letters/etc. from strings
		 * 
		 * more commonly, it is used for user input in the
		 * console application.
		 * By default, the scanner will delimit by ' ' (space)
		 * 
		 * Note:System.in is the call for taking user input
		 */
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("Tell me a thing... and I will" +
		" repeat it to you!");
		
//		input = scanner.next();
//		input = scanner.nextLine();
		int number = scanner.nextInt();
		//the line above is what takes user input
		System.out.println("Your input was "+"'"+number+"'");
		
		System.out.println("=====END=====");

	}

}
