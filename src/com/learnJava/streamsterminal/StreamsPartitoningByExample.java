package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamsPartitoningByExample {

    public static Map<Boolean,List<Student>> partitioningBy_1(){
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;

       return
                StudentDataBase.getAllStudents()
                    .stream()
                    .collect(partitioningBy(gpaPredicate));

    }

    public static Map<Boolean, Set<Student>> partitioningBy_2(){
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;

        return
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(partitioningBy(gpaPredicate,toSet()));

    }

    public static void main(String[] args) {

        System.out.println(partitioningBy_1());
        System.out.println(partitioningBy_2());
    }
}
