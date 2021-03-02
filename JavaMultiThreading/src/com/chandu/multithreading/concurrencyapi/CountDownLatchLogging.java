package com.chandu.multithreading.concurrencyapi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchLogging implements Runnable {

	CountDownLatch latch;

	CountDownLatchLogging(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing CountDownLatchLogging");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with Initializing CountDownLatchLogging");
		latch.countDown();
	}

}
