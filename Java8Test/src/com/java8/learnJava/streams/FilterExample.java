package com.java8.learnJava.streams;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class FilterExample {

    public static List<Student> filterStudents() {
        Predicate<Student> gradeLevelGreaterThan3 = (student) -> student.getGradeLevel() >= 3.8;
        Predicate<Student> femaleGender = (student) -> student.getGender().equals("female");

        List<Student> filteredStudentList = StudentDataBase.getAllStudents()
                .stream()
                .filter(gradeLevelGreaterThan3.and(femaleGender)) // combining predicates
                //.filter(femaleGender)
                .collect(toList());

        return filteredStudentList;
    }

    public static void main(String[] args) {
        System.out.println("Filtered Students based on the conditions: " + filterStudents());
    }
}