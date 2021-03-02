package com.chandu.multithreading.concurrencyapi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchUI implements Runnable {

	CountDownLatch latch;

	CountDownLatchUI(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing CountDownLatchUI");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with CountDownLatchUI Initialization");
		latch.countDown();
	}

}
