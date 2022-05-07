package com.java8.features.functionalinterface;

import java.util.function.Predicate;

// The predicate is a predefined FI, having only one abstract method: test(T, t)
// Whenever we want to check some boolean conditions then we can go for Predicates.
// Use: Predicate can be used when there is a need for boolean return type.
// Advantages: Code Reusability
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> length = str -> str.length() > 5;
        System.out.println("Length is > 5 :: " + length.test("Anil Kumar"));

        SupplierPredefinedFI supplierPredefinedFI = new SupplierPredefinedFI();
        System.out.println("Current Date :: " + supplierPredefinedFI.currentDate.get());
    }
}
