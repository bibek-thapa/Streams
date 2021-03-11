package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamsSumAvgExample {

    public static int sum(){

      return   StudentDataBase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNotebooks));

    }

    public static Double average(){

        return   StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNotebooks));

    }

    public static void main(String[] args) {

        System.out.println(sum());
        System.out.println(average());

    }
}
