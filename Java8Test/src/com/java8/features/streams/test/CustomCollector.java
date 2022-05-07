package com.java8.features.streams.test;

import com.java8.features.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class CustomCollector {
    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" || "),              // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                        (j1, j2) -> j1.merge(j2),                   // combiner
                        StringJoiner::toString);                    // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }
}
