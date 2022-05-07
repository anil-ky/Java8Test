package com.java8.features.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

// Use of BiConsumer, BiFunction, and BiPredicate but No BiSupplier
// When we need two arguments in Predefined Functional Interface, so for that BiConsumer, BiFunction, and BiPredicate
// but NO BiSupplier because there in no input in Supplier.
public class BiPredicateBiFunction {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> sumPredicate = (a, b) -> a + b >= 5;
        System.out.println("BIPredicate:: " + sumPredicate.test(2, 2));

        BiFunction<Integer, Integer, Integer> productFunction = (a, b) -> a * b;
        System.out.println("BIFunction:: " + productFunction.apply(5, 12));

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println("BIConsumer:: " + a * b);
        biConsumer.accept(2, 2);
    }
}