package com.java8.features.streams;

import com.java8.features.model.Address;
import com.java8.features.model.Gender;
import com.java8.features.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomStreamsTest {
    public static void main(String[] args) {
        List<Person> personList = getPersonsList();

        // Get the  person age < 35 years in reverse order
        personList.stream()
                .filter(person -> person.getAge() < 36)    //.sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .filter(Person::isLocal)
                .sorted(Comparator.comparingInt(Person::getAge).reversed()) // comparators added in Java 8
                .limit(4)
                .map(person -> person.getName() + " | " + person.getAge())
                .forEach(System.out::println);

        //List<Address> addressList = personList.stream().map(Person::getAddress).collect(Collectors.toList());
        List<Address> addressList = personList.stream().map(person -> person.getAddress()).collect(Collectors.toList());

        System.out.println("addressList: " + addressList.size());
        //addressList.stream().map(address -> address.city).forEach(System.out::println);


        // Collecting updated stream
        Stream<Person> personsStream = personList.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
                .distinct()
                .filter(Person::isLocal)
                .limit(3);
        //.map(person -> person.getName()) //.collect(Collectors.toList()); to List<String>
        //.forEach(System.out::println);

        // Containers: Collectors
        Set<Person> personsSet = personsStream.collect(Collectors.toSet()); // Set
        Map<String, Person> personsMap = personList.stream().collect(Collectors.toMap(e -> e.getName(), e -> e)); // Map

        // Collectors
        String names = personList
                .stream()
                //.limit(3)
                .map(Person::getName)
                .collect(Collectors.joining(" | "));

        System.out.println(names);

        // group by age
        Map<Integer, List<Person>> personsAgeGroup = personList.stream().collect(Collectors.groupingBy(Person::getAge));

        // count persons in each age group
        Map<Integer, Long> personsAgeGroupCount = personList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        // parallel streams
        // only when more than 10,000 elements to process, even then measure the time and memory
        Map<Integer, List<Person>> personsAgeGroupParallel = personList.stream()
                .parallel()                // very easy and deceptive
                .collect(Collectors.groupingBy(Person::getAge));

        // Don't concurrently modify the source of the stream.

    }

    private static List<Person> getPersonsList() {
        List<Person> personList = new ArrayList<>();


        personList.add(new Person("Anil", 40, new Address("line1", "City1", "123455", "Country1"), Gender.MALE));
        personList.add(new Person("Kumar", 32, true));
        personList.add(new Person("Test", 30, new Address("line2", "City2", "123456", "Country2"), Gender.FEMALE));
        personList.add(new Person("John", 5, true));
        personList.add(new Person("Sagar", 10, new Address("line3", "City3", "123457", "Country3"), Gender.MALE));
        personList.add(new Person("Rohan", 34, true));
        personList.add(new Person("Joe", 86, new Address("line4", "City4", "123458", "Country4"), Gender.FEMALE));
        personList.add(new Person("David", 31, true));
        personList.add(new Person("Lucky", 36, new Address("line5", "City5", "123459", "Country5"), Gender.FEMALE));

        return personList;
    }

}
