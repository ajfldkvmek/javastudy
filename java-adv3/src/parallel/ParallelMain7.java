package parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        // logic 처리 전용 ThreadPool 추가
        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThreads = 3;

        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100); // 스레드 순서확인 위한 대기
        }
        requestPool.close();
        logicPool.close();

    }

    private static void logic(String requestName, ExecutorService logicPool) {
        log("[" + requestName + "] START");

        long start = System.currentTimeMillis();

        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> logicPool.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {
                    // lambda 는 기본적으로 체크예외를 던질 수 없도록 설계됨
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).sum();

        long end = System.currentTimeMillis();

        log("[" + requestName + "] time: "  + (end - start) + "ms, sum: " + sum);

    }
}
