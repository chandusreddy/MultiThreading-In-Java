package com.chandu.multithreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolExecutorMain {
	public static void main(String args[]) {
		// Getting instance of ThreadPoolExecutor using Executors.newCachedThreadPool
		// factory method
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		for (int i = 1; i <= 10; i++) {
			DataFileReader df = new DataFileReader("File :" + i);
			System.out.println("A new file has been added to read : " + df.getFileName());
			threadPoolExecutor.execute(df);
		}
		threadPoolExecutor.shutdown();

	}
}
