package com.chandu.multithreading.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Current Time = " + new Date());
		// Created ScheduledThreadPoolExecutor object with the Factory method of
		// Executors class : newScheduledThreadPool

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 3; i++) {
			Thread.sleep(5000);
			ScheduledThreadPoolExecutorExample task = new ScheduledThreadPoolExecutorExample("Task " + i);
			// ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit)
			scheduledThreadPool.schedule(task, 5, TimeUnit.SECONDS);
		}

		// Adding some delay
		Thread.sleep(10000);

		scheduledThreadPool.shutdown();
		System.out.println("Completed all threads");
	}

}
