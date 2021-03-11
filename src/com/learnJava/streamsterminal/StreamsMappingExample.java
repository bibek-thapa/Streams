package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {



    public static void main(String[] args) {

       List<String> nameList =  StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList()));

        Set<String> nameSet =  StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet()));
        System.out.println("nameList: " + nameList);
        System.out.println("nameList: " + nameSet);
    }
}
