package com.chandu.multithreading.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolWithFixedDelay {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Current Time = " + new Date());
		// Created ScheduledThreadPoolExecutor object

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			ScheduledThreadPoolExecutorExample task = new ScheduledThreadPoolExecutorExample("Task " + i);
			// using the scheduleWithFixedDelay method
			scheduledThreadPool.scheduleWithFixedDelay(task, 5, 10, TimeUnit.SECONDS);
		}

		// Adding some delay
		Thread.sleep(30000);

		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Completed all threads");
	}

}
