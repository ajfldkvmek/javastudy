package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class ParallelMain3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();
        // ThreadPool 준비
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 1. 작업을 분할 (fork)
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);


        // 2. 분할한 작업 처리 - submit 같이 반환같이 있는 경우
        // Runnable 이 아니라 Callable 을 구현하여야한다.
        Future<Integer> future1 = executorService.submit(task1);
        Future<Integer> future2 = executorService.submit(task2);

        // 3. join - 처리한 결과 합치기 - get 은 결과가 나올 떄 까지 대기
        int result1 = future1.get();
        int result2 = future2.get();
        int sum = result1 + result2;


        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            log("작업 완료 result: " + sum);
            return sum;
        }
    }

}
