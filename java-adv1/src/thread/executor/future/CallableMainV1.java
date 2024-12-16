package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //pool의 크기가 1인 executor 생성
        //아래 코드는
        //new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockedQueue<>()); 와 같은 코드
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result value::" + result);
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
