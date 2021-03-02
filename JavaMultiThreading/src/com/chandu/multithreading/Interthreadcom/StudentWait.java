package com.chandu.multithreading.Interthreadcom;

public class StudentWait implements Runnable {

	Course course;

	public StudentWait(Course course) {
		super();
		this.course = course;
	}

	@Override
	public void run() {
		synchronized (course) {
			System.out.println(Thread.currentThread().getName() + " is waiting for the Course to be completed: "
					+ course.getTitle());
			try {
				course.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": Course has been completed now! from StudentWait");

		}
	}
}
