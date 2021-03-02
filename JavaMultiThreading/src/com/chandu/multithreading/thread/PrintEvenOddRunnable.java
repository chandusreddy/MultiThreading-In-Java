package com.chandu.multithreading.thread;

public class PrintEvenOddRunnable implements Runnable {

	public int PRINT_NUMBERS = 10;
	static int number = 1;
	int remainder;
	static Object lock = new Object();

	PrintEvenOddRunnable(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS) {
			synchronized (lock) {
				while (number % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {

		PrintEvenOddRunnable odd = new PrintEvenOddRunnable(1);
		PrintEvenOddRunnable even = new PrintEvenOddRunnable(0);

		Thread t1 = new Thread(odd, "Thread with Odd  Number:  ");
		Thread t2 = new Thread(even,"Thread with Even Number:  ");

		t1.start();
		t2.start();
	}
}
