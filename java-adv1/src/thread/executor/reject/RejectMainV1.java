package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class RejectMainV1 {

    public static void main(String[] args) {
//        SynchronousQueue 를 사용한 이유: size 가 0 이기 때문에 reject 를 즉시 받음
        ExecutorService executor =  new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
// AbortPolicy 는 RejectedExecutionException 의 구현체이다
//        ExecutorService executor =  new ThreadPoolExecutor(1, 1, 0,
//                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());

        executor.submit(new RunnableTask("task1"));

        try {
            executor.submit(new RunnableTask("task2"));
        } catch (RejectedExecutionException e) {
            log("요청초과");
            //포기, 재시도 등 원하는 로직 작성
        }
        executor.close();

    }
}
