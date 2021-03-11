package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int noOfNoteBooks(){
     return   StudentDataBase.getAllStudents()
                .stream()
                .filter(student-> student.getGradeLevel()>=3)
                .filter(student -> student.getGender() == "female")
                .map(Student::getNotebooks)
              //  .reduce(0,(a,b)-> a+b);
                .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {

        System.out.println(noOfNoteBooks());
    }
}
