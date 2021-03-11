package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsMapExample {

   public static List<String> namesList(){
      return  StudentDataBase.getAllStudents().stream()
               .map(Student::getName)
                .map(String::toUpperCase)
               .collect(toList());
    }
    public static void main(String[] args) {

       System.out.println(namesList());
    }
}
