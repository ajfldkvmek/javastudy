package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue{

    private final Queue<String> Q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if(Q.size() == max) {
            log("[put] 큐가 가득 참, 버림::" + data);
            return;
        }
        Q.offer(data);
    }

    @Override
    public synchronized String take() {
        if(Q.isEmpty()) {
            return null;
        }
        return Q.poll();
    }

    //원칙은 synchronized 해야하지만 예제라 생략
    @Override
    public String toString() {
        return Q.toString();
    }
}
