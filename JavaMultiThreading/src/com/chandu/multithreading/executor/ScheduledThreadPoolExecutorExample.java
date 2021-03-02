package com.chandu.multithreading.executor;

import java.util.Date;

public class ScheduledThreadPoolExecutorExample implements Runnable {

	private String taskName;

	public ScheduledThreadPoolExecutorExample(String s) {
		this.taskName = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start Time for " + taskName + " " + new Date());
		// Process task here
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End Time for " + taskName + " " + new Date());
	}

	@Override
	public String toString() {
		return this.taskName;
	}

}
