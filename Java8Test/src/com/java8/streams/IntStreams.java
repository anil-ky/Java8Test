package com.java8.streams;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreams {
	public static void main(String[] args) throws IOException {
		
		int numbers[] = {10, 4, 19, 12, 3, 8};
		
		int minVal = IntStream.of(numbers).min().getAsInt(); //System.out.println(minVal);
		//IntStream.of(numbers).min().ifPresent(min -> System.out.println(min)); // lamda
		//IntStream.of(numbers).min().ifPresent(System.out::println);
		IntStream.of(numbers).max(); IntStream.of(numbers).average(); IntStream.of(numbers).count();IntStream.of(numbers).sum();
		
		// Summary Statistics
		IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
		statistics.getMin(); statistics.getMax(); statistics.getSum();
		
		// Find 3 distinct smallest numbers from an array of int
		IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println); // Original Array is not mutated.
		IntStream.of(numbers).distinct().sorted().limit(3).sum(); // even we can call min, max, count and etc methods.
		
		//Int Stream Create
		IntStream.of(numbers);														// of
		IntStream.range(1, 100).forEach(num -> System.out.print(num + "|")); 		// range
		IntStream.rangeClosed(1, 100).forEach(num -> System.out.print(num + "|"));	// range closed
		IntStream.generate(supplier());												// supplier
		
		//Int Process
		IntStream.of(numbers).distinct().sorted().limit(13).skip(3)
					.filter(num -> num % 2 == 0) // only even
					.map(num -> num * 2) // double each number
					.boxed(); // covert each number to Integer.
		
		//Int Consume
		IntStream.of(numbers).max(); IntStream.of(numbers).average(); // math operations
		IntStream.range(1, 100).toArray();							  // collect into array
		IntStream.range(1, 100).boxed().collect(Collectors.toList()); // collect into list
		IntStream.of(numbers).anyMatch(number -> number % 2 == 1);  // is there any odd number | returns boolean
		IntStream.of(numbers).allMatch(number -> number % 2 == 1);  // all are odd numbers     | returns boolean
		
	}

	private static IntSupplier supplier() {
		return null;
	}
}
