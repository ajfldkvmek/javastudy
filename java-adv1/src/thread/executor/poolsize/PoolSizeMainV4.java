package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV4 {

//    static final int TASK_SIZE = 1100;      //1. 일반
//    static final int TASK_SIZE = 1200;    //2. 긴급
    static final int TASK_SIZE = 1201;    //3. 거절

    public static void main(String[] args) {
        ExecutorService es =
                new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        printState(es);
        // 만약 이 상황에서 LinkedBlockingQueue 를 사용하게 되면 큐를 초과할 수 없기 때문에 maximumSize 가 나올 수 없다.

        long startMs = System.currentTimeMillis();

        for (int i = 1; i <= TASK_SIZE; i++) {
            String taskName = "task" + i;
            try{
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch(RejectedExecutionException e) {
                log(taskName + " -> " + e);
            }
        }
        es.close();
        long endMs = System.currentTimeMillis();

        log("총 작업 시간::" + (endMs - startMs)/1000 );
    }

}
