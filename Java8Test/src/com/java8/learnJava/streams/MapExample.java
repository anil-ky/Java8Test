package com.java8.learnJava.streams;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {

    private static List<String> namesUpperCase(List<Student> names) {
        List<String> namesUpperCase = names.stream() // Stream<Student>
                .map(Student::getName)               // Converts to Stream<String>
                .map(String::toUpperCase)            // Stream<String> -> UpperCase Operation on each element
                .collect(Collectors.toList());       // returns List - terminal operation
        return namesUpperCase;
    }

    private static Set<String> namesSetUpperCase(List<Student> students) {
        Set<String> namesUpperCase = students.stream() // Stream<Student>
                .map(Student::getName)                 // Converts to Stream<String>
                .map(String::toUpperCase)              // Stream<String> -> UpperCase
                .collect(Collectors.toSet());                     // returns List - terminal operation
        return namesUpperCase;
    }

    private static Map<String, Integer> namesLengthMap(ArrayList<String> names) {

        Map<String, Integer> namesLengthMap = names.stream()        // Stream<String>
                .collect(Collectors.toMap(String::toString, String::length));  // returns Map

        return namesLengthMap;
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("dan");
        names.add("jenny");

        System.out.println("namesUpperCase List : " + namesUpperCase(StudentDataBase.getAllStudents()));
        System.out.println("namesUpperCase Set : " + namesSetUpperCase(StudentDataBase.getAllStudents()));
        System.out.println("namesLengthMap : " + namesLengthMap(names));

        List<String> countriesList = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");

        String countriesStr = countriesList.stream().map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println(countriesStr);
    }
}