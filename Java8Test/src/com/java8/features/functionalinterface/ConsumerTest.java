package com.java8.features.functionalinterface;

import java.util.function.Consumer;

// Consumer
// Consumer<T>: It will consume items. Consumers never return anything, they just consume.

// Consumer Chaining
// We can combine and chain multiple consumers together with using andThen.
// There is only one way to combine consumers which is andThen. No, compose in consumer.
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.println("consumer test: " + i * i);
        consumer.accept(5);
        Consumer<Integer> integerConsumer = i -> System.out.println("integer consumer test: " + i * 2);
        integerConsumer.accept(5);
        consumer.andThen(integerConsumer).accept(5);

        // Compile time error as compose is not available for consumer
        // consumer.compose(integerConsumer).accept(2);
    }
}