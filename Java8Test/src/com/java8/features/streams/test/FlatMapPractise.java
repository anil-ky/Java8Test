package com.java8.features.streams.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FlatMapPractise {
    public static void main(String[] args) {

        // FlatMap: transform the objects of a stream into another type of objects by utilizing the map operation
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo_" + i)));

        // create bars
        // Now we have a list of three foos each consisting of three bars.
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        // In order to resolve the inner string foo of an outer instance you have to add multiple null checks
        // to prevent possible NullPointerExceptions:
        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        // The same behavior can be obtained by utilizing optionals flatMap operation:
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);


    }
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }

    Foo() {}
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}
