package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

/**
 *  병렬 스트림을 사용할 때 한번에 많은 요청이 발생하면 공용풀 병목 현상이 발생할 수 있다.
 *  (여러 요청이 제한된 스레드풀을 두고 경쟁하면서 요청의 성능이 저하됨)
 *  이렇게 될 경우 parallel 을 사용하지 않는 것이 작업이 더 빨리 끝날 수 도 있음
 *
 *   **************************************************************
 *   그렇기 때문에 실무에서 공용풀은 절대 I/O 바운드 작업을 하면 안된다!!!!!!!!!!!
 *
 *   공용풀은 반드시 cpu 바운드(계산 집약적) 작업에만 사용해라
 *
 *   실무에서는 공용풀 보다는 별도의 풀을 만들어 사용함
 */
public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {

        // 병렬 수 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        System.out.println("ForkJoinPool.commonPool() = " + ForkJoinPool.commonPool());

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThreads = 3;

        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100); // 스레드 순서확인 위한 대기
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");

        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, (a, b) -> a + b);

        long end = System.currentTimeMillis();

        log("[" + requestName + "] time: "  + (end - start) + "ms, sum: " + sum);

    }

}
