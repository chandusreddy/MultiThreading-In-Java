package com.chandu.multithreading.concurrencyapi;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
	public static void main(String[] args) {
		try {
			CountDownLatch latch = new CountDownLatch(3);

			// Initializing three dependent thread i.e. UI, DAO and logging

			CountDownLatchUI ui = new CountDownLatchUI(latch);
			Thread uiThread = new Thread(ui);

			CountDownLatchDAO daoi = new CountDownLatchDAO(latch);
			Thread daoThread = new Thread(daoi);

			CountDownLatchLogging logi = new CountDownLatchLogging(latch);
			Thread loggingThread = new Thread(logi);

			uiThread.start();
			daoThread.start();
			loggingThread.start();
			// Main thread will wait until above threads get completed
			latch.await();

			System.out.println("Initialization has been completed, main thread can proceed now");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
