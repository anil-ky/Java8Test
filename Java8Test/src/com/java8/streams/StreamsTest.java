package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("Oned");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Changed");
		
		Stream<String> myStream =  list.stream().filter(element -> element.contains("d"));
		System.out.println(myStream.count());
		//list.forEach(System.out::println);
		
		// Matching
		
		boolean isValid = list.stream().anyMatch(element -> element.contains("d")); // true
		boolean isValidOne = list.stream().allMatch(element -> element.contains("d")); // false
		boolean isValidTwo = list.stream().noneMatch(element -> element.contains("z")); // false
		
		System.out.println(isValid);
		System.out.println(isValidOne);
		System.out.println(isValidTwo);
		
		Stream.empty().allMatch(Objects::nonNull); // true
		Stream.empty().anyMatch(Objects::nonNull); // false
		
		//
		
		List<String> lines = Arrays.asList("spring", "node", "Test");

        List<String> result = lines.stream().filter(line -> !"Test".equals(line))     
                .collect(Collectors.toList());              

        result.forEach(System.out::println);
	}

}
