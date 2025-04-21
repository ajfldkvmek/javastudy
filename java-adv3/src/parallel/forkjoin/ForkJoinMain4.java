package parallel.forkjoin;

import parallel.HeavyJob;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain4 {

    public static void main(String[] args) {

        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .parallel() // 병렬스트림을 위한 parallel() 메소드
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long end = System.currentTimeMillis();

        log(sum + " tasks processed in " + (end - start) + " ms");
    }

}
