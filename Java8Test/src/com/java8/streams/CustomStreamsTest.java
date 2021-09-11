package com.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomStreamsTest {

	public static void main(String[] args) {
		List<Person> personList = getPersonsList();
		
		
		//List<Address> addressList = personList.stream().map(Person::getAddress).collect(Collectors.toList());
		List<Address> addressList = personList.stream().map(person -> person.getAddress()).collect(Collectors.toList());
		
		System.out.println("addressList: " + addressList.size());
		addressList.stream().forEach(System.out::println);
		
		
		
		Stream<Person> personsStream = personList.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
							.distinct()
							.filter(Person::isLocal)
							.limit(3);
							//.map(person -> person.getName()) //.collect(Collectors.toList()); to List<String>
							//.forEach(System.out::println);
		
		// Containers: Collectors
		Set<Person> personsSet = personsStream.collect(Collectors.toSet());
		//Map<String, Person> personsMap = personList.stream().limit(3).collect(Collectors.toMap(e-> e.name, e -> e)); //TODO
		
		String names = personList.stream().limit(3).map(Person::getName).collect(Collectors.joining(" | ")); System.out.println(names);

		// group by age
		Map<Integer, List<Person>> personsAgeGroup = personList.stream().collect(Collectors.groupingBy(Person::getAge));
		
		// count persons in each age group
		Map<Integer, Long> personsAgeGroupCount = personList.stream().collect(Collectors.groupingBy(Person::getAge,  Collectors.counting()));
		
		// parallel streams
		// only when more than 10,000 elements to process
		Map<Integer, List<Person>> personsAgeGroupParallel = personList.stream()
																.parallel()				
																.collect(Collectors.groupingBy(Person::getAge));
		
		// Don't concurrently modify the source of the stream.
		

	}
	
	private static List<Person> getPersonsList() {
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("Anil", 40, new Address("line1", "City1", "123455", "Country1")));
		personList.add(new Person("Kumar", 32, true));
		personList.add(new Person("Test", 30, new Address("line2", "City2", "123456", "Country2")));
		personList.add(new Person("John", 5, true));
		personList.add(new Person("Sagar", 10, new Address("line3", "City3", "123457", "Country3")));
		personList.add(new Person("Rohan", 10, true));
		personList.add(new Person("Joe", 86, new Address("line4", "City4", "123458", "Country4")));
		personList.add(new Person("David", 30, true));
		personList.add(new Person("Lucky", 40, new Address("line5", "City5", "123459", "Country5")));
		
		return personList;
	}

}
