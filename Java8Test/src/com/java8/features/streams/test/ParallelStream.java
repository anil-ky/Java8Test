package com.java8.features.streams.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {

        List<Integer> plistOfNumbers = Arrays.asList(1, 2, 3, 4);
        plistOfNumbers.parallelStream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
    }
}