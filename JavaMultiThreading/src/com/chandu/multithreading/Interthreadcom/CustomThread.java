package com.chandu.multithreading.Interthreadcom;

public class CustomThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Thread is running :" + i);
		}

	}

	public static void main(String[] args) {
		CustomThread ct1 = new CustomThread();
		CustomThread ct2 = new CustomThread();
		// You can not directly call run method to create a thread, you need to call
		// start method to create a new thread.
		// If you call run method directly , it won’t create a new thread and it will be
		// in same stack as main.
		// ct1.run();
		// ct2.run();
		ct1.start();
		ct2.start();

	}
}
