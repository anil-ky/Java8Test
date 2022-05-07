package com.java8.features.lamda.learning.examples;

public class MyRunnable {

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable( ) {

			@Override
			public void run() {
				System.out.println("This is my Thread...");
				
			}
			
		});
		
		thread.start();
		
		Thread thread2 = new Thread(() -> System.out.println("This is new Thread..."));
		thread2.start();
		thread2.run();
	}

}
