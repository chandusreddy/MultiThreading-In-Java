package com.chandu.multithreading.executor;

public class DataFileReader implements Runnable {

	private final String fileName;

	public String getFileName() {
		return fileName;
	}

	public DataFileReader(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("Fetching data from " + fileName + " by " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);// Reading file
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("Read file successfully: " + fileName + " by " + Thread.currentThread().getName());
	}

}
