package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static Map<String, List<Student>> groupStudentsByGender(){
     return   StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
    }

    public static Map<String, List<Student>> groupStudentsByGpa(){
        return   StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
    }

    public static void twoLevelGroupint(){

      Map<Integer,Map<String,List<Student>>>  studentMap =  StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,groupingBy(student->student.getGender()=="Female" ? "scholarship" :"no scholarship")));
        System.out.println(studentMap.get(2));

    }


    public static Map<String,Integer> twoLeavelGrouping_2(){

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName,summingInt(Student::getNotebooks)));
    }

    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupBy(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName ,LinkedHashMap::new, toSet()));
    }


    public static Map<Integer,Optional<Student>> getTopGpa(){

       return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,maxBy(Comparator.comparing(Student::getGpa))));
    }

    public static Map<Integer,Student> getTopGpaRemoveOptional(){

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
    }

    public static Map<Integer,Student> getMinGpaRemoveOptional(){

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,collectingAndThen(minBy(Comparator.comparing(Student::getGpa)),Optional::get)));
    }


    public static void main(String[] args) {

        System.out.println(groupStudentsByGender());
        twoLevelGroupint();
        System.out.println(twoLeavelGrouping_2());
        System.out.println(threeArgumentGroupBy());
        System.out.println(

        );

        System.out.println(getTopGpa());
        System.out.println(getTopGpaRemoveOptional());

        System.out.println(getMinGpaRemoveOptional());

    }
}
