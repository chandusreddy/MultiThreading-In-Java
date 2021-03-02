package com.chandu.multithreading.executor;

import java.util.concurrent.Callable;

public class FutureTaskExample implements Callable {

	int a;
	int b;
	long sleepTime;

	public FutureTaskExample(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(sleepTime);
		return a * b;
	}

}
