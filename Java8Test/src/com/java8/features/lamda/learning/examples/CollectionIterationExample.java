package com.java8.features.lamda.learning.examples;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Dickens", 62), new Person("Thomas", "Dickens", 61),
				new Person("Charlotte", "Dickens", 63), new Person("Mathew", "Dickens", 64),
				new Person("John", "Dickens", 65), new Person("David", "Dickens", 66));
		
		
		System.out.println("Using lambda for each loop.");
		personList.forEach(p -> System.out.println(p));
		personList.forEach(System.out::println);
	}
}
