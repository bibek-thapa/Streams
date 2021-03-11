package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.lang.*;

public class StreamsExample {

    public static void main(String[] args) {

        //student name and there activities in a map
        Predicate<Student> studentPredicate = (student -> student.getGradeLevel()>=3);
        Predicate<Student> studentgpaPredicate = (student -> student.getGpa()>=3.9);


        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().parallelStream()
                .peek(student -> {
                    System.out.println(student);
                })
                .filter(studentPredicate)
                .peek(student -> System.out.println("/"+ student))
                .filter(studentgpaPredicate)
                .peek(student -> System.out.println("//"+ student))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentMap);
    }
}
