package com.java8.features.lamda.learning.basics;

/**
 * This is a functional interface implementation.
 *
 * @author Anil Kumar Yellamandala
 * @since 11.09.2021
 */
public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello World!!!");
    }
}
