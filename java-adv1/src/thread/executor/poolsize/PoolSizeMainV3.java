package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV3 {

    public static void main(String[] args) {

      /*  ExecutorService es =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
        위 코드는 아래와 같음
        new ThreadPoolExecutor(기본사이즈, 초과사이즈, 대기시간, 대기시간단위, 스레드대기큐);
      */
//        ExecutorService es = Executors.newCachedThreadPool();
        /**
         *  SynchronousQueue 는 core 사이즈가 없어 스레드가 들어오는 즉시 사이즈가 추가됨
         *  따라서 매번 초과 스레드가 생성되어 pool 사이즈가 계속 늘어나는 형태
         *  작업의 처리속도가 매우 빠르고 cpu 메모리를 매우 유연하게 사용가능하다.
         *  하지만 메모리 자원은 한정되어 있기 때문에 많은 메모리가 요구될 경우 성능저하가 발생하거나 시스템이 다운 될 수 있다.
         *
         *  이 떄문에 점진적인 사용자 증가의 경우에는 서버 증설과 같은 방법으로 가능하지만
         *
         *  갑작스런 요청증가가 발생할 경우 시스템 전체가 늘어지는 영향이 생긴다.
         *
         *  스레드는 메모리를 많이 사용하는 작업이기 때문에 잘 관리하는 것이 중요하다.
         *
         *  고정 스레드풀 전략은 서버자원은 여유가 있고 사용자만 느려짐
         *  캐시 스레드풀 전략은 서버자원을 최대로 활용하기 때문에 서버가 감당가능한 임계점을 넘는 순간 서버자체가 다운될 수 있음
         */
        ExecutorService es =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue<>());
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 == ");
    }
}
