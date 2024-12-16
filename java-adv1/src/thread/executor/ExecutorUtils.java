package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
//        인터페이스인 ExecutorService 보다 구현체인 ThreadPoolExecutor 에 더 다양한 메소드가 구현되어있다.
//        ThreadPoolExecutor poolExecutor 는 캐스팅을 한 것인데 instanceof 에서 바로 사용할 수 있게 되었다.
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {

            int pool = poolExecutor.getPoolSize();
            int queue = poolExecutor.getQueue().size();
            int active = poolExecutor.getActiveCount();
            long completedTask = poolExecutor.getCompletedTaskCount();

            log("[pool=" + pool + ", active=" + active +
                    ", queuedTask=" + queue + " ,completedTask=" + completedTask + "]");
        } else {
            log(executorService);
        }
    }

    //추가
    public static void printState(ExecutorService executorService, String taskName) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {

            int pool = poolExecutor.getPoolSize();
            int queue = poolExecutor.getQueue().size();
            int active = poolExecutor.getActiveCount();
            long completedTask = poolExecutor.getCompletedTaskCount();

            log(taskName + " -> [pool=" + pool + ", active=" + active +
                    ", queuedTask=" + queue + " ,completedTask=" + completedTask + "]");
        } else {
            log(executorService);
        }
    }
}
