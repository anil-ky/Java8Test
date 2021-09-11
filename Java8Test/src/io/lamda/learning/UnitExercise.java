package io.lamda.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitExercise {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Dickens", 62), new Person("Thomas", "Dickens", 61),
				new Person("Charlotte", "Dickens", 63), new Person("Mathew", "Dickens", 64),
				new Person("John", "Dickens", 65), new Person("David", "Dickens", 66));

		// Step 1: Sort the list by firstname
		Collections.sort(personList, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		
		// Step 2: Print all elements
		printConditionally(personList, p -> true);

		printConditionally(personList, p1 -> p1.getFirstName().startsWith("C"));
		
		// Sort list by first Name and print the list which start with the letter 'C'
		personList.stream() // .sorted(Comparator.comparing(Person::getFirstName))
				.map(Person::getFirstName).sorted().filter(p -> p.startsWith("C")).forEach(System.out::println);

	}

	private static void printConditionally(List<Person> persons, Condition condition) {
		for (Person person : persons) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}
}

interface Condition { // use Predicate instead of Condition
	boolean test(Person p);
}
