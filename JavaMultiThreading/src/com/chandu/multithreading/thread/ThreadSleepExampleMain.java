package com.chandu.multithreading.thread;

public class ThreadSleepExampleMain {

	public static void main(String[] args) {
		RunnableThreadExample ft = new RunnableThreadExample();

		Thread t = new Thread(ft);
		t.start();
		long startTime = System.currentTimeMillis();
		// synchronized(lockedObject) {
		// Thread.sleep(1000);
		// It does not release the lock on lockedObject.
		// So either after 1000 mili seconds, current thread will wake up, or after we
		// call
		// t. interrupt() method.
		try {
			// putting thread on sleep
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long timeDifference = (endTime - startTime);
		System.out.println("Time difference between before and after sleep call: " + timeDifference);

	}

}
