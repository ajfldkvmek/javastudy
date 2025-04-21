package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain2 {

    public static void main(String[] args) {

//        자신의 pc 의 프로세서 수(cpu 코어)를 알 수 있다
//        int processorCount = Runtime.getRuntime().availableProcessors();
//        ForkJoinPool commonPool = ForkJoinPool.commonPool(); // 공용풀

//        commonPool 의 수는 cpu 코어 의 수 -1 개 이다
//        log("processorCount: " + processorCount + ", commomPool: " + commonPool.getParallelism());

        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();
        log("[생성] " + data);

        SumTask task = new SumTask(data);
        Integer result = task.invoke(); // 이렇게 invoke 만 해주면 공용풀 사용해서 invoke 해줌

        log("result: " + result);

    }

}
