package com.java8.test;

public class Test2 {
    public static void main(String args[]) {
        try {
            throw new ArithmeticException();
        } catch (Exception e) {
            throw new NullPointerException();
        } finally {
            throw new NumberFormatException();
        }
    }
}