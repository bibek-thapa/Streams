package com.learnJava.streams;

import com.learnJava.data.StudentDataBase;

public class StreamsMatchExample {

    public static boolean allMatch(){

        //for this every student must have gpa above 3.0 . If all of students
        // have gpa above 3 it will return trued
     return   StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.0);
    }

    public static boolean anyMatch(){

/*
    If it finds any gpa above 4.1 then it will return true

 */
        return   StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=4.1);
    }

    public static boolean noneMatch(){

/*
    If it finds any gpa above 4.1 then it will return true

 */
        return   StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=4.1);
    }


    public static void main(String[] args) {
        System.out.println(allMatch());

        System.out.println(anyMatch());

        System.out.println(noneMatch());
    }
}
