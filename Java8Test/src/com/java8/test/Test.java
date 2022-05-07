package com.java8.test;


import java.util.Objects;

class A {
    int i;

    @Override
    public boolean equals(Object o) {
        A a = (A) o;
        return i == a.i;
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(i);
    }*/
}

public class Test {
    public static void main(String[] argh) {
        A a = new A();
        a.i = 10;

        A b = new A();
        b.i = 20;

        System.out.println(a.equals(b));
    }
}
