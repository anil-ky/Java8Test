package com.java8.learnJava.methodreferences;

import com.java8.learnJava.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierMethodReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;
    // Student student = Student::new; // compilation issue
    static Function<String, Student> stringStudentFunction = Student::new;
    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(stringStudentFunction.apply("KUMAR"));
    }
}
