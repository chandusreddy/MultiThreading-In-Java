package com.chandu.multithreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorMainTest {

	public static void main(String[] args) {
		// Getting instance of ThreadPoolExecutor using Executors.newFixedThreadPool
		// factory method
		ThreadPoolExecutor threadexecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			DataFileReader df = new DataFileReader("File" + i);
			System.out.println("A New File has been addded to the Reading List: " + df.getFileName());
			// submitting the task to the executor
			threadexecutor.execute(df);
		}
		threadexecutor.shutdown();
	}

}
