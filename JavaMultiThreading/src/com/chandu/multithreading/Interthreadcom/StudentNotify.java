package com.chandu.multithreading.Interthreadcom;

public class StudentNotify implements Runnable {
	Course course;

	public StudentNotify(Course course) {
		super();
		this.course = course;
	}

	@Override
	public void run() {
		synchronized (course) {
			System.out.println("Student is Starting the Course : " + course.getTitle());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			course.setCompleted(true);
			System.out.println("The Course has been completed now from StudentNotify");

			course.notify();
			// This is used to notify all the users
			//course.notifyAll();
			System.out.println("notify  StudentWait Class");

		}
	}

}
