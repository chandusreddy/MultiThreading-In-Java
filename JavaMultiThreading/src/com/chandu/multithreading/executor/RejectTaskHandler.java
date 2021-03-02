package com.chandu.multithreading.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTaskHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		DataFileReader df = (DataFileReader) r;
		System.out.println("Sorry!: We cannot read the file: " + df.getFileName());

	}

}
