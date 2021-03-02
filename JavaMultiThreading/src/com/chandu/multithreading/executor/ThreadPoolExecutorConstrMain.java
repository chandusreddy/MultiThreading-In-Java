package com.chandu.multithreading.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorConstrMain {

	public static void main(String[] args) {
		// queue below is used to store waiting task
		BlockingQueue queue = new LinkedBlockingQueue(4);

		// Thread factory below is used to create new threads
		ThreadFactory thFactory = Executors.defaultThreadFactory();

		// Rejection handler in case the task get rejected
		RejectTaskHandler rth = new RejectTaskHandler();
		// ThreadPoolExecutor constructor to create its instance
		// public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long
		// keepAliveTime,
		// TimeUnit unit,BlockingQueue workQueue ,ThreadFactory
		// threadFactory,RejectedExecutionHandler handler) ;
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10L, TimeUnit.MILLISECONDS, queue,
				thFactory, rth);

		for (int i = 1; i <= 10; i++) {
			DataFileReader df = new DataFileReader("File " + i);
			System.out.println("A new file has been added to read : " + df.getFileName());
			// Submitting task to executor
			threadPoolExecutor.execute(df);
		}
		threadPoolExecutor.shutdown();
	}

}
