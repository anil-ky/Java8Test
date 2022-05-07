package com.java8.features.lamda.learning.examples;

public class MethodReferencesExample {

	public static void main(String[] args) {
		
		Thread t = new Thread(() -> printMessage()); // MethodReferencesExample::printMessage ==== () -> printMessage()
		Thread t2 = new Thread(MethodReferencesExample::printMessage);
		t.start();
		t2.start();
	}
	
	public static void printMessage() {
		System.out.println("Printing a message for you.."); // System.out::println, replace p -> method(p)
	}
	

}
