package com.java8.learnJava.streams;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        // Before Java 8
        Map<String, List<String>> studentsMap = new HashMap<String, List<String>>();
        for(Student student: StudentDataBase.getAllStudents()) {
            if (student.getGradeLevel() >= 3)
                studentsMap.put(student.getName(), student.getActivities());
        }

        // In Java 8 using streams
        Predicate<Student> gradePredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> gpaPredicate = student -> student.getGradeLevel() >= 3.9;

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream() //.parallelStream do not forget.
                .filter(gpaPredicate) // Stream<Student>
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println("studentMap  : " + studentMap);

        List<String> studentActivities = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .map(Student::getActivities) //<Stream<List<Activities>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        studentActivities.stream().forEach(System.out::println);

        System.out.println("Student Activities  : " + studentActivities);

        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((student -> {
                    System.out.println("Student: " + student);
                }))
                .map(Student::getName) //<Stream<List<Activities>>
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);
    }
}