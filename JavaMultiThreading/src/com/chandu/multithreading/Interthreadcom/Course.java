package com.chandu.multithreading.Interthreadcom;

public class Course {

	public Course(String title) {
		super();
		this.title = title;
	}

	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	boolean isCompleted;

}
