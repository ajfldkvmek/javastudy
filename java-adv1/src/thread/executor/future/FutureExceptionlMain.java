package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionlMain {

    private static boolean mayInterruptIfRunning = true;
//    private static boolean mayInterruptIfRunning = false; //false 인 경우 이미 작업중인 놈은 취소하지말고 그냥 계속진행

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");

        Future<Integer> future = es.submit(new Excallable());
        sleep(1000); //잠시대기

        try {
            log("future.get() 호출 시도, future.state()::" + future.state());
            Integer result = future.get();
            log("result value = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log("e = " + e); //
            Throwable cause = e.getCause();
            log("cause = " + cause);
        }
        es.close();

    }

    static class Excallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외발생");
            throw new IllegalStateException("ex!");
        }

    }

}
