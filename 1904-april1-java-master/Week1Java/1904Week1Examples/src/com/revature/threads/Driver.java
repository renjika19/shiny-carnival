package com.revature.threads;

public class Driver {

	public static void main(String[] args) {
		System.out.println("=======BEGINNING OF THREAD EX========");
		Thread t1 = new Thread(new ThreadThread(), "Thread1");
		Thread t2 = new Thread(new RunnableThread(), "Thread2");
		//at this point, the threads are "New"
		t1.start();
		t2.start();
		//at this point, the threads are "Runnable"
		for(int i =0; i<50; i++) {
			System.out.println("\t\t\t"+Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("=======END OF THREAD EX========");
		//right after here is where the main method terminates

	}
	/*
	 * Notable thread methods
	 * -sleep(): put the thread in a sleeping status (can be interrupted)
	 * 		-NOTE: thread does not relinquish control in this state
	 * -wait(): puts the thread into a wait status (can't be interrupted)
	 * -notify(): wakes up another thread that is blocked at random
	 * -notifyAll(): wakes up all blocked threads
	 * -isDaemon(): checks to see if a thread is a daemon thread
	 * 		- a daemon thread is any low priority thread that executes
	 * in the background (ex: garbage collector). may continue after app
	 * ends
	 * -join(): will force thread to wait for others to terminate before
	 * terminating itself
	 * -setDaemon(): sets the status of a thread to a daemon thread
	 * -isAlive(): checks to see if the thread state is alive
	 * -start(): forks the thread into a multithreading state
	 */

}
