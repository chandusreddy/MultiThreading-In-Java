package com.chandu.multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {

	public static void main(String[] args) {
		FutureTaskExample ftk1 = new FutureTaskExample(10, 20, 2000l);
		FutureTaskExample ftk2 = new FutureTaskExample(20, 40, 4000l);

		FutureTask<Integer> futuretsk1 = new FutureTask<>(ftk1);
		FutureTask<Integer> futuretsk2 = new FutureTask<>(ftk2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futuretsk1);
		executor.execute(futuretsk2);

		while (true) {
			try {
				if (!futuretsk1.isDone()) {
					System.out.println("FutureTask1 output=" + futuretsk1.get());
				}
				if (!futuretsk2.isDone()) {
					System.out.println("Waitng for futureTask2 for completion");
					System.out.println("FutureTask2 output=" + futuretsk2.get());
				}
				if (futuretsk1.isDone() && futuretsk2.isDone()) {
					System.out.println("Completed both the FutureTasks, shutting down the executors");
					executor.shutdown();
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
