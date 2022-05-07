package com.java8.features.streams.test;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFilterMapSortPractice {
    public static void main(String[] args) {

        // mapToInt(), mapToLong() and mapToDouble:
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3

        // Primitive streams can be transformed to object streams via mapToObj():
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        // combined example: the stream of doubles to object streams
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        // filter: the first string "d2" passes filter then forEach, only then the second string "a2" is processed.
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    // System.out.println("filter: " + s);
                    return true;
                });
        //.forEach(s -> System.out.println("forEach: " + s));

        // always use filter first then sort and map
        // Now, map is only called once so the operation pipeline performs much faster for larger numbers of input elements.
        // Keep that in mind when composing complex method chains.
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // Reusing Streams#
        //Java 8 streams cannot be reused. As soon as you call any terminal operation the stream is closed:
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        stream.noneMatch(s -> true);   // exception


        // To overcome this limitation we have to to create a new stream chain for every terminal operation we want to execute.
        // Each call to get() constructs a new stream on which we are save to call the desired terminal operation.
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
    }
}
