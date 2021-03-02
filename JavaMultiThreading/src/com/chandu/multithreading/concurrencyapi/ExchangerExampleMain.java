package com.chandu.multithreading.concurrencyapi;

import java.util.concurrent.Exchanger;

public class ExchangerExampleMain {
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();
		// Starting two threads
		new Thread(new Producer(exchanger)).start();
		new Thread(new Consumer(exchanger)).start();
	}
}

class Producer implements Runnable {

	Exchanger ex;

	Producer(Exchanger ex) {
		this.ex = ex;

	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			Person person = null;
			if (i == 0)
				person = new Person("Sachin");
			else
				person = new Person("Shewag");

			try {
				// exchanging with an dummy Country object
				Person dummyPerson = (Person) ex.exchange(person);
				System.out.println("Got Person object from Consumer thread : " + dummyPerson.getName());
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

class Consumer implements Runnable {

	Exchanger ex;

	Consumer(Exchanger ex) {
		this.ex = ex;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				// Getting Person object from producer thread
				// giving dummy Person object in return
				Person person = (Person) ex.exchange(new Person("Dummy"));
				System.out.println("Got Person object from Producer thread : " + person.getName());

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

}
