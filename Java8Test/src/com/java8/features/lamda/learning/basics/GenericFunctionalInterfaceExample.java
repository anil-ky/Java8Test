package com.java8.features.lamda.learning.basics;

public class GenericFunctionalInterfaceExample {

    public static void main(String[] args) {
        MathComputerGeneric<Integer> calc = (number) -> {
            int fact = 1;
            for (int j = 1; j <= number; j++) {
                fact = fact * j;
            }
            return fact;
        };

        System.out.println(calc.compute(3));
        System.out.println(calc.compute(4));
        System.out.println(calc.compute(5));

        MathComputerGeneric<String> strUpper = (name) -> {
            return name.toUpperCase();
        };

        System.out.println(strUpper.compute("anil"));
    }
}
