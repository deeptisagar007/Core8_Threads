package com.marlabs.threadExamples;

import java.util.Scanner;

class Thread1 extends Thread {
	public Thread1(String name) {
		this.setName(name);
		System.out.println("In Thread: " + this.getName());
	}

	@Override
	public void run() {
		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("Thread: " + this.getName() + " value: " + counter);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread2 extends Thread {
	public Thread2(String name) {
		this.setName(name);
		System.out.println("In Thread: " + this.getName());
	}

	@Override
	public void run() {
		for (int counter = 1; counter <= 10; counter++) {
			System.out.println("Thread: " + this.getName() + " value: " + counter);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadforArea extends Thread {
	public ThreadforArea(String name) {
		this.setName(name);
		System.out.println("In Thread: " + this.getName());
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Width:");
		int width = scanner.nextInt();
		System.out.println("Enter Height:");
		int height = scanner.nextInt();
		double area = (0.5 * width * height);
		System.out.println("The area is: " + area);
		scanner.close();
	}
}

public class JoinThreadExample {

	public static void main(String[] args) {
		System.out.println("Join Thread Main Starts");
		Thread mainThread = Thread.currentThread();
		mainThread.setName("Main Thread");

		Thread1 thread1 = new Thread1("First Thread");
		Thread2 thread2 = new Thread2("Second Thread");
		ThreadforArea areaThread = new ThreadforArea("Area Thread");

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		areaThread.start();
		try {
			areaThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Join Threads Main Ends");
	}

}
