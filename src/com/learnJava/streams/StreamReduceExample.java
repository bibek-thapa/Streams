package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static int performMultiplication(List<Integer> integerList){
      return  integerList.stream()
                .peek(a-> System.out.println(a))
                .reduce(1,(a,b) -> a*b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList){
        return  integerList.stream()
                .reduce((a,b) -> a*b);
    }

    public static Optional<Student> getHighestGpaStudent(){
       return  StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2)->
                    (s1.getGpa()>s2.getGpa())?s1:s2
                );
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println(performMultiplication(integers));

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());

        Optional<Student> studentOptional = getHighestGpaStudent();
        if(getHighestGpaStudent().isPresent()){
            System.out.println(getHighestGpaStudent().get());
        }
    }
}
