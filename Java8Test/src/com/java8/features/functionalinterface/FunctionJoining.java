package com.java8.features.functionalinterface;

import java.util.function.Function;

// Function Joining/Chaining
// We can combine/chain multiple functions together with andThen and compose.
// There are two ways to combine them:
// f1.andThen(f2).apply(Input); First f1 then f2.
// f1.compose(f2).apply(Input); First f2 then f1.
// e.g; f1.andThen(f2).andThen(f3).andThen(f4).apply(Inputs);

public class FunctionJoining {
    public static void main(String str[]) {
        Function<Integer, Integer> function = i -> i * 2;
        System.out.println(function.apply(4));
        Function<Integer, Integer> function2 = j -> j * j * j;
        System.out.println(function2.apply(2));

        //Function Chaining
        int chainResult = function.andThen(function2).apply(2); // first function result will be passed as second function input
        int chainResultReverse = function.compose(function2).apply(2); // function2 will be executed first then the function
        System.out.println("andThen:: " + "" + chainResult + " compose:: " + chainResultReverse);
    }
}