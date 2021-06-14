package com.revature.threads;

import javax.management.RuntimeErrorException;

//the second way to make a thread, is to implement the Runnable Interface
public class RunnableThread implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println("\t\t"+Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		throw new RuntimeException();
//		note that if one thread terminates due to an exception, the other threads
//		will continue to execute
	}

}
