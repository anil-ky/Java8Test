package com.java8.features.streams.test;

import com.java8.features.model.Person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectPractise {
    public static void main(String[] args) {

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        // 1. collect
        // the good part is Java 8 supports various built-in collectors via the Collectors class.
        List<Person> filtered =
                persons.stream()
                        .filter(p -> p.getName().startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(filtered);    // [Peter, Pamela]

        // 2. Group by age
        Map<Integer, List<Person>> personsByAge
                = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // 3.determining the average age of all persons:
        // Collectors are extremely versatile. You can also create aggregations on the elements of the stream.
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println("Average Age: = " + averageAge);     // 19.0

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("Age Summary: = " + ageSummary); // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        // The next example joins all persons into a single string:
        // The join collector accepts a delimiter as well as an optional prefix and suffix.
        String phrase = persons
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase); // In Germany Max and Peter and Pamela are of legal age.

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map); // {18=Max, 23=Peter;Pamela, 12=David}

        persons.stream().collect(Collectors.toMap(person -> person.getAge(),
                person -> person.getName(), (p1, p2) -> p1 + ";" + p2));

    }
}
