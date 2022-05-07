package com.java8.learnJava.methodreferences;

import com.java8.learnJava.data.Student;
import com.java8.learnJava.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /**
     * Class::instanceMethod
     */
    static Consumer<Student> c1 = System.out::println; //student -> System.out.println(student);


    /**
     * instance::instanceMethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
        StudentDataBase.getAllStudents().forEach(c3);
    }
}
