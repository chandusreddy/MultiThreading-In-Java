package com.chandu.multithreading.concurrencyapi;

/*CyclicBarrier is synchronized aid which allows set of threads 
 * to wait for each other at common barrier points.
 * It is called cyclic because it can be reused once waiting threads are released.
 * */
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

	public static void main(String[] args) {
        /*
         * Create CountDownLatch with 3 parties, when all 3 parties
         * will reach common barrier point CyclicBarrrierEvent will be
         * triggered 
         */
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierEvent());
 
        RunnableTask runnableTask1=new RunnableTask(cyclicBarrier,1000);
        RunnableTask runnableTask2=new RunnableTask(cyclicBarrier,2000);
        RunnableTask runnableTask3=new RunnableTask(cyclicBarrier,3000);
 
        //Create and start 3 threads
        new Thread(runnableTask1,"Thread-1").start();
        new Thread(runnableTask2,"Thread-2").start();
        new Thread(runnableTask3,"Thread-3").start();
 
        /*
         * We are reusing cyclic barrier using below threads
         * */
        RunnableTask runnableTask4=new RunnableTask(cyclicBarrier,4000);
        RunnableTask runnableTask5=new RunnableTask(cyclicBarrier,5000);
        RunnableTask runnableTask6=new RunnableTask(cyclicBarrier,6000);
 
        // Create and start 3 more threads
        new Thread(runnableTask4,"Thread-4").start();
        new Thread(runnableTask5,"Thread-5").start();
        new Thread(runnableTask6,"Thread-6").start();
 
    }
 
}