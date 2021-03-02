package com.chandu.multithreading.Interthreadcom;

public class InterThreadMain {

	public static void main(String[] args) {

		// Course object on which wait and notify method will be called.
		Course course = new Course("Java");
		StudentWait st1 = new StudentWait(course);
		StudentWait st2 = new StudentWait(course);

		// StudentWait threads which will wait for completion of book
		Thread th1 = new Thread(st1, "Thread1");
		Thread th2 = new Thread(st2, "Thread2");

		th1.start();
		th2.start();

		// To ensure both students started waiting for the book
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// StudentNotify thread which will notify once book get completed
		StudentNotify stn = new StudentNotify(course);
		Thread notifyth = new Thread(stn);
		notifyth.start();

	}

}
