package parallel.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class CompletableFutureMain {

    /**
     *  CompletableFuture 을 사용하는 경우에도 아래와 같이 쓰레드풀을 직접 생성하여 사용해야 한다.
     *  그렇지 않으면 기본적으로 commonPool 을 사용하기 떄문에 병목현상이 발생할 가능성이 높다
     */

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> log("Fork/Join")); // Fork/Join 공용풀 (별도 풀 지정없으면 CommonPool 로 동작)
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(() -> log("CustomPool"), executorService); // 별도의 풀 지정
        Thread.sleep(300);
        executorService.close();

    }
}
