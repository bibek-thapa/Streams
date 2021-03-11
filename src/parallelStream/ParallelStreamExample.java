package parallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes){
      long startTime = System.currentTimeMillis();
        for(int i=0 ; i<numberOfTimes;i++){
            supplier.get();
        }
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    public static int sumSequentialStream(){

        return IntStream.rangeClosed(1,10000)
                .sum();
    }

    public static int sumParallelStrem(){

        return IntStream.rangeClosed(1,10000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(checkPerformanceResult(ParallelStreamExample::sumSequentialStream,20));
        System.out.println(checkPerformanceResult(ParallelStreamExample::sumParallelStrem,20));
    }
}
