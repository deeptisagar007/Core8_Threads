package com.marlabs.threadExamples;

class ThreadEx extends Thread {

	public ThreadEx(String name) {
		// this.name = name;
		this.setName(name);
		System.out.println("Thread: " + this.getName() + " Started");
	}

	@Override
	public void run() {
		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("In Thread " + Thread.currentThread().getName() + " value " + counter);
		}

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class ThreadExample1 {

	public static void main(String[] args) {
		System.out.println("ThreadExample1 Main Starts");

		Thread mainThread = Thread.currentThread();
		mainThread.setName("Main Thread");
		System.out.println("Current Main Thread is Alive: " + mainThread.isAlive());

		ThreadEx thread1 = new ThreadEx("Child1");
		ThreadEx thread2 = new ThreadEx("Child2");
		ThreadEx thread3 = new ThreadEx("Child3");

		thread1.setDaemon(true);
		thread1.start();
		thread2.start();
		thread3.start();

		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("Thread " + Thread.currentThread().getName() + " value " + counter);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Child1 is Alive: " + thread1.isAlive());
		System.out.println("Child1 is Demon: " + thread1.isDaemon());
		System.out.println("Child1 is Alive: " + thread1.isAlive());

		System.out.println("ThreadExample1 Main Ends");
	}

}
