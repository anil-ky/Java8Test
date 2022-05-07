package com.java8.features.streams;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamsTest {
    public static void main(String[] args) throws IOException {

        int numbers[] = {10, 4, 19, 12, 3, 8};

        IntStream.of(numbers);    // create stream
        IntStream.range(1, 100).forEach(num -> System.out.print(num + "||"));        // range, end exclusive
        IntStream.rangeClosed(1, 100).forEach(num -> System.out.print(num + "|"));    // range closed, end inclusive
        IntStream.generate(supplier()); // pass any supplier

        // 1. min and max for the int stream
        int minVal = IntStream.of(numbers).min().getAsInt(); // getAsInt() throw exception if the array is empty.
        IntStream.of(numbers).min().ifPresent(min -> System.out.println("Min : " + min)); // lamda
        System.out.print("Max : ");
        IntStream.of(numbers).max().ifPresent(System.out::println);

		IntStream.of(numbers).min(); // min
		IntStream.of(numbers).max(); // max
        IntStream.of(numbers).average(); // average
        IntStream.of(numbers).count(); // count
        IntStream.of(numbers).sum(); // sum

        // Summary Statistics
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        statistics.getMin();
        statistics.getMax();
        statistics.getSum();
        statistics.getAverage();
        statistics.getCount();

        IntStream.of(numbers).distinct();				// distinct numbers
        IntStream.of(numbers).sorted();					// sort the array
        IntStream.of(numbers).limit(3);					// get first 3 numbers
        IntStream.of(numbers).skip(3);					// skip first 3 numbers
        IntStream.of(numbers).filter(i -> i % 2 == 0);  // filter the numbers
		IntStream.of(numbers).map( num -> num * 2);		// double the each number
		IntStream.of(numbers).boxed();					// convert each integer number to Integer


        // Find 3 distinct smallest numbers from an array of int
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println); // Original Array is not mutated.

        // sum of first 3 distinct smallest numbers from an array
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .sum(); // even we can call min, max, count and etc methods.

        //Int Process
        IntStream.of(numbers).distinct().sorted().limit(13).skip(3)
                .filter(num -> num % 2 == 0) // only even
                .map(num -> num * 2) // double each number
                .boxed(); // covert each number to Integer.

        //Int Consume
        IntStream.range(1, 100).toArray();                              // collect into array
        IntStream.range(1, 100).boxed().collect(Collectors.toList()); 	// collect into list
        IntStream.of(numbers).anyMatch(number -> number % 2 == 1);  	// is there any odd number | returns boolean
        IntStream.of(numbers).allMatch(number -> number % 2 == 1);  	// all are odd numbers     | returns boolean
    }

    private static IntSupplier supplier() {
        IntSupplier intSupplier = () -> (int) (Math.random() * 10);
        return intSupplier;
    }
}
