package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class RejectMainV2 {

    public static void main(String[] args) {
//        SynchronousQueue 를 사용한 이유: size 가 0 이기 때문에 reject 를 즉시 받음
        ExecutorService executor =  new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
        // DiscardPolicy 는 문제발생시 그냥 바로 버림
        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));

        executor.close();

    }
}
