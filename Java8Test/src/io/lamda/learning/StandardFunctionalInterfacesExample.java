package io.lamda.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample {
	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Dickens", 62), new Person("Thomas", "Dickens", 61),
				new Person("Charlotte", "Dickens", 63), new Person("Mathew", "Dickens", 64),
				new Person("John", "Dickens", 65), new Person("David", "Dickens", 66));

		// Step 1: Sort the list by firstname
		Collections.sort(personList, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		
		// Step 2: Print all elements
		performConditionally(personList, p -> true, p -> System.out.println(p));
		
		// Step 3: Print all elements which has first name starts with 'C'
		performConditionally(personList, p1 -> p1.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
	}

	private static void performConditionally(List<Person> persons, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person person : persons) {
			if (condition.test(person)) {
				consumer.accept(person);
			}
		}
	}
	
	private static void performConditionally(List<Person> persons, Predicate<Person> condition) {
		for (Person person : persons) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}
}
