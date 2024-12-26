package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class ExecutorShutdownMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("TaskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_000)); //100초 대기

        printState(es);

        log("== shutdown 시작 == ");
        shutdownAndWaitTermination(es);
        log("== shutdown 완료 ==");

        printState(es);
//        es.close();

    }

    private static void shutdownAndWaitTermination(ExecutorService es) {
        es.shutdown(); // non-blocking, 새로운 작업 받기 않음, 처리중이허가 큐에 이미 대기중인 작업은 처리, 이후에 풀의 스레드를 종료
        try {
            //이미 대기중인 작업들을 모두 완료할 때 까지 10초 기다림
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                // 정상종료가 너무 오래걸리면...
                log("서비스 정상종료 실패 ->강제 종료 시도");
                es.shutdownNow();
                //작업이 취소될 때 까지 대기
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 종료되지 않았습니다");
                }
            }
        } catch (InterruptedException e) {
            //awaitTermination() 으로 개디중인 현재 스렉드가 인터럽트 될 수 있다.
            es.shutdownNow();
        }
    }

}