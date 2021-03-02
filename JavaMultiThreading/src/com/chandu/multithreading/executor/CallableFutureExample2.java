package com.chandu.multithreading.executor;

import java.util.concurrent.Callable;

// Returning the Factorial of the given num

public class CallableFutureExample2 implements Callable {
	private double num;

	CallableFutureExample2(double num) {
		this.num = num;
	}

	@Override
	public Double call() throws Exception {

		System.out.println("Calculating Factorial of num with " + Thread.currentThread().getName());
		Thread.sleep(5000);
		double fact = 1;
		for (int i = 2; i <= num; i++) {
			fact *= i;
		}
		// returning the power of the given num
		return fact;
	}
}
