package com.chandu.multithreading.thread;

public class DaemonThreadExample implements Runnable {

	@Override
	public void run() {
		if (Thread.currentThread().isDaemon())
			System.out.println(Thread.currentThread().getName() + "  is daemon thread");
		else
			System.out.println(Thread.currentThread().getName() + "  is user thread");
	}

	public static void main(String[] args) {
		DaemonThreadExample st = new DaemonThreadExample();
		// creating threads
		Thread th1 = new Thread(st, "Thread 1");
		Thread th2 = new Thread(st, "Thread 2");
		Thread th3 = new Thread(st, "Thread 3");
		// now th2 is daemon thread
		th2.setDaemon(true);

		th1.start();// starting all threads
		th2.start();
		th3.start();

		// now converting user thread to daemon thread after starting the thread will
		// throw java.lang.IllegalThreadStateException
		// th2.setDaemon(true);

	}
}
