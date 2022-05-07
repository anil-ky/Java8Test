package com.java8.learnJava.streams_terminal;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.Collection;
import java.util.stream.Collectors;

public class StreamsJoiningExample {

    public static String joining(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining()); // appends all the strings to produce the output,
    }

    public static String joiningWithDelimiter(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joiningWithDelimiterWithPrefix(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","[","]"));
    }

    public static void main(String[] args) {

        System.out.println("Names : "+ joining());
        System.out.println("Names With Delimiter : "+ joiningWithDelimiter());
        System.out.println("Names With Delimiter Prefix and Suffix : "+ joiningWithDelimiterWithPrefix());
    }
}
