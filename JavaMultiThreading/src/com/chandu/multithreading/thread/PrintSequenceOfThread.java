package com.chandu.multithreading.thread;

public class PrintSequenceOfThread implements Runnable {

	public int PRINT_NUMBERS = 10;
	static int number = 1;
	int reminder;
	static Object lock = new Object();

	PrintSequenceOfThread(int reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS - 1) {
			synchronized (lock) {
				while (number % 3 != reminder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "" + number);
				number++;
				lock.notifyAll();
			}

		}

	}

	public static void main(String[] args) {
		PrintSequenceOfThread r1 = new PrintSequenceOfThread(1);
		PrintSequenceOfThread r2 = new PrintSequenceOfThread(2);
		PrintSequenceOfThread r3 = new PrintSequenceOfThread(0);

		Thread t1 = new Thread(r1, "Thread with T1:");
		Thread t2 = new Thread(r2, "Thread with T2:");
		Thread t3 = new Thread(r3, "Thread with T3:	");

		t1.start();
		t2.start();
		t3.start();
	}

}
