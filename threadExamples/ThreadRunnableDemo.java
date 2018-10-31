package com.marlabs.threadExamples;

class RunnableThread implements Runnable {

	@Override
	public synchronized void run() {
		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("In " + Thread.currentThread().getName() + " Value: " + counter);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ThreadRunnableDemo {

	public static void main(String[] args) {
		System.out.println("Runnable Thread Main Starts");

		RunnableThread rT1 = new RunnableThread();
		RunnableThread rT2 = new RunnableThread();

		Thread thread1 = new Thread(rT1, "First Runnable");
		Thread thread2 = new Thread(rT2, "Second Runnable");

		thread1.start();
		thread2.start();

		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("In " + Thread.currentThread().getName() + " Value: " + counter);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Runnable Thread Main Ends");
	}

}
