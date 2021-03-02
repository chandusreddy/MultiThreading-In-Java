package com.chandu.multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureMain {
	

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		System.out.println("Starting the Threads : ");
		
		// Defining the Future object references
		  Future FutureOfPower20;
		  Future FutureOfFactorial20;
		  Future FutureOfPower25;
		  Future FutureOfFactorial25;
		 
		  // Calling the ExecutorService Submit Method to calculate the power and factorial respectively.
		  FutureOfPower20=es.submit(new CallableFutureExample1(20));
		  FutureOfFactorial25=es.submit(new CallableFutureExample2(25));
		  FutureOfFactorial20=es.submit(new CallableFutureExample2(20));
		  FutureOfPower25=es.submit(new CallableFutureExample1(25));
		   try {
			   // Returning the ouput of the Future Callable methods.
		System.out.println("Square of "+25+" : "+FutureOfPower25.get());
		System.out.println("Square of "+20+" : "+FutureOfPower20.get());
		System.out.println("Factorial of "+20+" : "+FutureOfFactorial20.get());
		System.out.println("Factorial of "+25+" : "+FutureOfFactorial25.get());
		es.shutdown();
		   } catch (InterruptedException | ExecutionException e) {
		 
		    e.printStackTrace();
		   } 
		  System.out.println("Done");
		 }
	}


