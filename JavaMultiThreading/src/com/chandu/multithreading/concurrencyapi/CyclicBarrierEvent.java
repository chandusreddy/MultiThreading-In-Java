package com.chandu.multithreading.concurrencyapi;

public class CyclicBarrierEvent implements Runnable {
	
	@Override
	 public void run() {
		 
         System.out.println("As 3 threads have reached common barrier point "
                      + ", CyclicBarrrierEvent has been triggered");
         System.out.println("You can update shared variables if any");
  }

}
