package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {

      /*  ExecutorService es =
                new ThreadPoolExecutor(2, nThread, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        위 코드는 아래와 같음
      */
        ExecutorService es = Executors.newFixedThreadPool(2);

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es);
        }
        es.close();
        log("== shutdown 완료 == ");
    }
}
