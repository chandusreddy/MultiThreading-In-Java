package com.chandu.multithreading.concurrencyapi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDAO implements Runnable {
	CountDownLatch latch;

	CountDownLatchDAO(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing CountDownLatchDAO");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with CountDownLatchDAO Initialization");
		latch.countDown();
	}

}
