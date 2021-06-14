package com.revature.threads;
/*
 * there are two ways to create a thread in java.
 * a thread is a simple flow of execution
 * multithreading is when multiple threads have branched out of the main
 * thread and execute concurrently
 * 
 * the gola of multithreading would be to share the work load among multiple
 * threads in an effort to finish a task faster.
 * 
 * With threads, Java has two ways to create them, these two ways are:
 * -EXTENDING the Thread Class
 * -IMPLEMENT the Runnable Interface
 */
public class ThreadThread extends Thread{
	/*
	 * In either case, for creating a thread, you must implement the run() method
	 * in order to designate what will be executed when you branch the thread
	 * off. The thread will fork and execute everything you wrote in the run
	 * method(). In order to actually branch the thread off, you need to invoke
	 * the start() method. Should you try to begin a thread by invoking run(),
	 * it will simply execute run()'s contents in a sequential manner in the
	 * main thread.
	 */
	
	@Override
	public void run() {
		for(int i =0; i<50; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		throw new RuntimeException();
		//exceptions also cause the termination state
		
	}

}
