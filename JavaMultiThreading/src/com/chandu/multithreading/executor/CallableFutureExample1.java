package com.chandu.multithreading.executor;

import java.util.concurrent.Callable;

// This is a Callable example to calculate the power of a given number

public class CallableFutureExample1 implements Callable {

	private double num;

	CallableFutureExample1(double num) {
		this.num = num;
	}

	@Override
	public Double call() throws Exception {

		System.out.println("Calculating Square of num with " + Thread.currentThread().getName());
		Thread.sleep(2000);
		// returning the power of the given num
		return Math.pow(num, num);
	}

}
