package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = true;
//    private static boolean mayInterruptIfRunning = false; //false 인 경우 이미 작업중인 놈은 취소하지말고 그냥 계속진행

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future state:  " + future.state());

        //일정시간 후 취소시도
        sleep(3000);

        //cancel() 호출
        log("future.cancel(" + mayInterruptIfRunning + ")" + "호출");
        boolean cancelResult = future.cancel(mayInterruptIfRunning);

        log("cancel(" + mayInterruptIfRunning + ") result::" + cancelResult);

        // 결과 확인
        try {
            log("future result::" + future.get());
        } catch (CancellationException c) { //runtimeException
            log("future 는 이미 취소되었습니다"); //cancel 되면 get()으로 반환을 받을 수 없다.
        } catch (InterruptedException |  ExecutionException e) {
            e.printStackTrace();
        }
        es.close();
    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중 : " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log("인터럽트발생");
                return "interrupted";
            }
            for (int i = 0; i < 10; i++) {
                log("작업중 : " + i);
            }
            return "completed";
        }

    }

}
