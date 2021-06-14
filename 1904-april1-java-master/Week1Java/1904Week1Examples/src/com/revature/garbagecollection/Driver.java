package com.revature.garbagecollection;

public class Driver {

	public static void main(String[] args) {
		// this demonstration will show why it is not
		//always most efficient to collect garbage
		//constantly
		for(int i = 0; i<1000000; i++) {
			Trubbish garbodor =new Trubbish(i);
			System.gc();//this method suggests to the
//			gc that it ought to take out the trash
//			soon
		}
	}

}
