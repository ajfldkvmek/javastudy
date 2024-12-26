package thread.executor.future;

import thread.executor.CallableTask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class InvokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(10);

        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);

        List<CallableTask> tasks = List.of(task1, task2, task3);

        List<Future<Integer>> futures = es.invokeAll(tasks); //invokeAll 은 모든 작업이 종료되어야 return 된다.
        //invokeAny 의 경우 반환 타입이 달리지는데 이 경우 Integer 을 반환한다. 즉 아무 작업들 중 어느 하나라도 끝나면 바로 반환하고 나머지 작업들은 취소처리한다.

        for (Future<Integer> future : futures) {
            Integer value = future.get();
            log("value::" + value);
        }
        es.close();

    }
}
