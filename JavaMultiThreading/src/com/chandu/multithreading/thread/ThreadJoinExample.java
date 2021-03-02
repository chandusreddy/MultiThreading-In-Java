package com.chandu.multithreading.thread;

public class ThreadJoinExample implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " Start");
			// thread sleeps for 5 secs
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Main thread execution starts");
		ThreadJoinExample tj = new ThreadJoinExample();

		Thread t1 = new Thread(tj, "Thread 1");
		Thread t2 = new Thread(tj, "Thread 2");
		Thread t3 = new Thread(tj, "Thread 3");

		t1.start();
		// lets wait for Thread 1 to die
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			// lets wait for Thread 2 to die or waits for 1 Sec
			t2.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t3.start();
		// complete all threads before completing main thread
		try {
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread Executions completes");
	}

}
