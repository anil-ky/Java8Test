package com.java8.features.streams.test;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        Stream<String> myStream = Arrays.stream(myArray);

        // map
        Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());
        String[] myNewArray = myNewStream.toArray(String[]::new);

        // filter
        Arrays.stream(myArray).filter(s -> s.length() > 4).toArray(String[]::new);
    }
}
