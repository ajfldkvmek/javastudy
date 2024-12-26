package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit() call");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시반환 future = " + future);

        log("future.get() 메소드 호출 시작 -> main 스레드 waiting");
        Integer result = future.get(); //결과가 나올 때 까지 메인스레드가 기다림
        log("future.get() 메소드 호출 완료 -> main 스레드 runnable");

        log("result value::" + result);
        log("future 완료, future = " + future);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable start");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("create value::" + value);
            log("Callable end");
            return value;
        }
    }
}
