package com.java8.learnJava.lambda;

import java.util.Comparator;

public class ComparatorLambda {

    public static int compareTwoIntegers(Comparator<Integer> comparator, int a, int b) {
        return comparator.compare(a, b);
    }

    public static void main(String[] args) {

        /**
         * Before Java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> if both are equal
                // 1 -> if o1 > o2
                //-1 -> if o1<o2
            }
        };

        System.out.println("comparator.compare: " + comparator.compare(1, 2));

        /**
         * In Java 8
         */
        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b); // type declaration is not required
        Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b); // concise form

        System.out.println("comparatorLambda.compare: " + comparatorLambda.compare(1, 2));

        /**
         * Comparator chaining happens only when the first comparators result is zero.
         */
        System.out.println("Result of chaining comparator is with equal inputs : " + comparatorLambda1.thenComparing(comparatorLambda1).compare(2, 2));
        System.out.println("Result of chaining comparator is with not equal inputs: " + comparatorLambda1.thenComparing(comparatorLambda1).compare(3, 2));
        System.out.println(comparatorLambda1.compare(1, 2));

        System.out.println("The greatest integer is : " + compareTwoIntegers(comparatorLambda, 2, 6));
    }
}