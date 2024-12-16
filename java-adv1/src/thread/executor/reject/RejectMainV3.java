package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV3 {

    public static void main(String[] args) {
//        SynchronousQueue 를 사용한 이유: size 가 0 이기 때문에 reject 를 즉시 받음
        ExecutorService executor =  new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        // CallerRunsPolicy 는 작업을 요청한 스레드에 대신 일을 시킴
        // 아래의 코드는 메인스레드가 요청자이기 때문에 메인 스레드가 작업을 처리하는 것을 볼 수 있음
        // 이 정책의 목적은 작업의 생성자가 일을 직접 처리하기 때문에 스레드를 생성하는 작업이 늦어지는 일이 발행한다
        // 즉 스레드의 작업생성이 빠른 경우 이 작업을 늦춰 생산속도를 조절하는 역할을 한다
        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));

        executor.close();

    }
}
