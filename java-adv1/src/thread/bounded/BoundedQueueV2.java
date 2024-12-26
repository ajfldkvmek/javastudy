package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue{

    private final Queue<String> Q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if(Q.size() == max) {
            log("[put] 큐가 가득 참, 소비자대기::" + data);
            sleep(1000);
        }
        Q.offer(data);
    }

    @Override
    public synchronized String take() {
        if(Q.isEmpty()) {
            log("[take] 큐에 데이터 없음, 소비자 대기" );
            sleep(1000);
        }
        return Q.poll();
    }

    
    //원칙은 synchronized 해야하지만 예제라 생략
    @Override
    public String toString() {
        return Q.toString();
    }
}
