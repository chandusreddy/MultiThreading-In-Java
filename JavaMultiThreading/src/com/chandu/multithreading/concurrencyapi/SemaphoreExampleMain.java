package com.chandu.multithreading.concurrencyapi;

public class SemaphoreExampleMain {
	public static void main(String[] args) throws InterruptedException {

		final SemaphoreExample sm = new SemaphoreExample(5);
		Runnable runnable1 = new Runnable() {

			@Override
			public void run() {
				try {
					sm.add("Sachin");
					sm.add("Dravid");
					sm.add("Shewag");
					sm.add("Yuvaraj");
					sm.add("Raina");
					System.out.println("Available Permits after adding: " + sm.getSemaphore().availablePermits());
					sm.add("Ganguly");
					System.out.println("Final list: " + sm.getArraylist());

				} catch (InterruptedException ie) {

				}
			}
		};
		
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Before removing elements: " + sm.getArraylist());
					Thread.sleep(5000);
					sm.remove("Raina");
					sm.remove("Yuvaraj");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.start();
		System.out.println("Available Permits before t2 starts : " + sm.getSemaphore().availablePermits());
		t2.start();
	}

}
