package com.marlabs.threadExamples;

class DemonThreadExample extends Thread {

	public DemonThreadExample(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println("In run");
		System.out.println("Current Thread: " + Thread.currentThread().getName());
	}
}

public class ThreadExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread1 = Thread.currentThread();
		System.out.println("Current Thread is: " + thread1.toString());
		thread1.setName("ChangedMain");
		System.out.println("Changed main name to: " + thread1.getName());

		DemonThreadExample demonThreadExampleObject = new DemonThreadExample("SelfCreatedDemonThread");
		demonThreadExampleObject.setDaemon(true);
		// demonThreadExampleObject.run();
		demonThreadExampleObject.start();
		System.out.println("Is demonThreadExampleObject Thread: " + demonThreadExampleObject.isAlive());
		System.out.println("Is demonThreadExampleObject Demon: " + demonThreadExampleObject.isDaemon());
		System.out.println("New Thread Name: " + demonThreadExampleObject.getName());
		System.out.println("Currently working thread: " + Thread.currentThread());

		Thread thread2 = new Thread();
		thread2.setDaemon(true);
		thread2.start();
		System.out.println("thread2 Priority" + thread2.getPriority());
		thread2.setPriority(8);
		System.out.println("thread2 Priority changed to: " + thread2.getPriority());
		System.out.println("Thread2 is Alive: " + thread2.isAlive());
		System.out.println("Is Thread2 Demon: " + thread2.isDaemon());
	}

}
