package com.java8.features.functionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPredefinedFI {
    public static void main(String[] args) {

        // Before Java 8
        FunctionPredefinedFI f = new FunctionPredefinedFI();
        int b = f.doubleIt(5);
        System.out.println("Before Java 8:: " + b);

        // Java 8
        Function<Integer, Integer> doubleIt = number -> number * number;
        System.out.println("After Java 8:: " + doubleIt.apply(5));
    }

    public int doubleIt(Integer i) {
        return i * i;
    }
}