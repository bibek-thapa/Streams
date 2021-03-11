package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    public static int findMaxValue(List<Integer> integerList){

      return   integerList.stream()
                //.reduce(0,(x,y) -> x>y ?x: y);
                .reduce(0,Integer::max);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList){

        return   integerList.stream()
                .reduce((x,y) -> x>y ?x: y);

    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList){

        return   integerList.stream()
                .reduce((x,y) -> x<y ?x: y);

    }


    //Dont use this when using min value . because it will always give
    //output to zero as zero is default value used
    public static int findMinValue(List<Integer> integerList){

        return   integerList.stream()
                //.reduce(0,(x,y) -> x<y ?x: y);
                .reduce(0,Integer::min);
    }
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
      //  System.out.println(findMaxValue(integerList));
        List<Integer> integerList1 = Arrays.asList();
        if(findMaxValueOptional(integerList1).isPresent()){
            System.out.println(findMaxValueOptional(integerList1).get());
        }

        if(findMaxValueOptional(integerList).isPresent()){
            System.out.println(findMinValueOptional(integerList).get());
        }
        System.out.println(findMinValue(integerList));

    }
}
