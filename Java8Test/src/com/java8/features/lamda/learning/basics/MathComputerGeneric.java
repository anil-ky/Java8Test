package com.java8.features.lamda.learning.basics;

/**
 * This is a generic functional interface.
 *
 * @author Anil Kumar Yellamandala
 * @since 12.09.2021
 */
@FunctionalInterface
public interface MathComputerGeneric<T> {
    public T compute(T t);
}