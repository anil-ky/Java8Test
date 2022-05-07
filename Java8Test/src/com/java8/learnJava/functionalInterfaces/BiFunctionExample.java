package com.java8.learnJava.functionalInterfaces;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) -> {

        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if (studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }));

        return studentGradeMap;

    };
    private static Map<String, String> loginPageLocs = new HashMap<>();
    static BiFunction<String, String, String> loginLocations = (sLocator, elementType) -> loginPageLocs.get(sLocator);

    public static String getLoginLocations(String sLocator, String elementType) {

        return loginPageLocs.get(elementType);
    }

    public static void main(String[] args) {

        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p2));

        loginLocations.apply("locator", "elementType");

    }
}
