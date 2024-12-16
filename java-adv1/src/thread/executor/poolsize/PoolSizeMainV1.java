package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;

import java.util.Objects;
import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);

        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es, "task1");

        es.execute(new RunnableTask("task2"));
        printState(es, "task2");

        es.execute(new RunnableTask("task3"));
        printState(es, "task3");

        es.execute(new RunnableTask("task4"));
        printState(es, "task4");

        es.execute(new RunnableTask("task5")); //할당된 작업이 pool 과 queue 모두 찼을 경우에 스레드풀을 1 늘린다.
        printState(es, "task5");

        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        try {
            es.execute(new RunnableTask("task7")); //스레드풀의 사이즈가 max를 넘으면 오류 발생
            //printState(es, "task7");
        } catch(RejectedExecutionException e) {
            log("task7 실행 예외 거절 발생::" + e);
        }
        sleep(3000);
        log("== 작업 수행 완료 == ");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 == ");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);

    }

}
