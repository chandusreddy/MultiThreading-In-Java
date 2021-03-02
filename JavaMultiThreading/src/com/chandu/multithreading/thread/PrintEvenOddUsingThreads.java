package com.chandu.multithreading.thread;

public class PrintEvenOddUsingThreads {
	boolean odd;
	int count = 1;
	int MAX = 20;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				System.out.println("Checking odd loop");

				while (!odd) {
					try {
						System.out.println("ODD Waiting..." + count);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("ODD Thread Count: " + count);
				count++;
				odd = false;
				notify();

			}
		}

	}

	public void printEven() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) {
			while (count < MAX) {
				System.out.println("Checking EVEN loop");

				while (odd) {
					try {
						System.out.println("EVEN Thread waiting: " + count);
						wait();
						System.out.println("Notified EVEN Thread:" + count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("EVEN thread Count:" + count);
				count++;
				odd = true;
				notify();

			}
		}
	}

	public static void main(String[] args) {

		PrintEvenOddUsingThreads eo = new PrintEvenOddUsingThreads();
		eo.odd = true;
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				eo.printEven();

			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				eo.printOdd();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}