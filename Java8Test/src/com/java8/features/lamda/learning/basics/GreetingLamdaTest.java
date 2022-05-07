package com.java8.features.lamda.learning.basics;

/**
 * This is a lamda testing with different usages.
 *
 * @author Anil Kumar Yellamandala
 * @since 11.09.2021
 */
public class GreetingLamdaTest {

    public static void doGreeting(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {

        // Usage 1: create an object to the greeting class and pass the implementation.
        HelloWorldGreeting greeting = new HelloWorldGreeting();
        doGreeting(greeting);

        // Usage 2: create an anonymous implementation to the greeting class and pass it.
        Greeting greeting2 = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello World for Anonymous!!!");
            }
        };
        doGreeting(greeting2);

        // Usage 3: create an lamda implementation to the greeting class and pass it.
        Greeting myLamdaFunction = () -> System.out.println("Hello World from Lambda!");
        doGreeting(myLamdaFunction);

        // Usage 4: pass the implementation as value.
        doGreeting(() -> System.out.println("Hello New World!!"));

        // Usage 5: directly calling the method on the reference.
        myLamdaFunction.perform();
    }
}