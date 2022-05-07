package com.java8.features.functionalinterface;

import java.util.function.Predicate;

// Predicate Joining/Chaining:
// The combining of predicates is called Predicate Joining.
// Three-way to join predicate: AND, OR, NEGATE.

public class PredicateJoining {
    public static void main(String str[]) {

        // greater than condition
        Predicate<String> predicate = value -> value.length() >= 5;
        System.out.println(predicate.test("check greater than 10"));

        // equals condition
        Predicate<String> secondPredicate = value -> value.length() % 2 == 0;

        System.out.println(secondPredicate.test("not long"));
        System.out.println(predicate.and(secondPredicate).test("my m ipsum dolor s"));
        System.out.println(predicate.or(secondPredicate).test("my string"));

        // negate: opposite of test
        System.out.println(predicate.negate().test("my string"));
    }
}