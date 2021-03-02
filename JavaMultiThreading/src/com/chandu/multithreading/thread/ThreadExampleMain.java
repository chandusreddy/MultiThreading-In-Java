package com.chandu.multithreading.thread;

public class ThreadExampleMain {

	public static void main(String[] args) {

		ExtendsThreadExample th = new ExtendsThreadExample();
		th.start();
		RunnableThreadExample rh = new RunnableThreadExample();
		Thread t = new Thread(rh);
		t.start();
		//If you try to start thread again , it will throw IllegalThreadStateException
		//t.start();

	}

}
