package com.java8.features.lamda.learning.examples;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] numbers = {10, 20, 30, 40, 50};
		int key = 0;
		
		processNumbers(numbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
		
	}

	private static void processNumbers(int[] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for(int i : numbers) {
			biConsumer.accept(i, key);
		}
		
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		return (v, k) -> {
			try {
			biConsumer.accept(v, k);
			} catch(Exception exception) {
				System.out.println("exception is caught at wrapperLambda...");
			}
		};
	}

}
