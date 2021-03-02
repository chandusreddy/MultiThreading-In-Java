package com.chandu.multithreading.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * BlockingQueue is special type of queue which is used when one thread produces object 
 * and another thread consumes it.
 * Producer thread will keep inserting objects to queue until it reaches upper limit. 
 * Once this queue size has reached that limit then producer 
 * thread will get blocked and won’t able to put objects into
 *  queue until consumer thread starts consuming it.*/

public class BlockingQueueMain {
	public static void main(String args[]) {
		BlockingQueue queue = new ArrayBlockingQueue(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
