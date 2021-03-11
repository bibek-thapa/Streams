package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsFlatMapExample {

    public static Set<String> printStudentActivities(){
     return  StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .peek(student-> System.out.println(student))
                .flatMap(List::stream)
                .peek(student-> System.out.println("/"+student))
                .distinct()
                .sorted()
                .collect(toSet());
    }

    public static long getStudentActivities(){
        return  StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .peek(student-> System.out.println(student))
                .flatMap(List::stream)
                .peek(student-> System.out.println("/"+student))
                .distinct()
                .count();
    }
    public static void main(String[] args) {
        System.out.println(printStudentActivities());
        System.out.println(getStudentActivities());
    }
}
