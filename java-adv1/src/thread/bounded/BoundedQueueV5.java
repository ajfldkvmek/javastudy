package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV5 implements BoundedQueue{

    /**
     *  LOCK 은 하나지만
     *  대기공간인 CONDITION 은 여러개로 나눌 수 있다.
     */
    private final Lock LOCK = new ReentrantLock();
    private final Condition PRODUCER_COND = LOCK.newCondition(); //스레드가 기다리는 대기집합
    private final Condition CONSUMER_COND = LOCK.newCondition(); //스레드가 기다리는 대기집합
    private final Queue<String> Q = new ArrayDeque<>();
    private final int max;
    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        LOCK.lock();
        try{
            while(Q.size() == max){
                log("[put] 큐가 가득 참, 소비자대기::" + data);
                try{
                    PRODUCER_COND.await();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            Q.offer(data);
            log("[put] 생산자 데이터 저장, CONSUMER_COND 호출");
            CONSUMER_COND.signal();
        } finally {
            LOCK.unlock();
        }
    }

    @Override
    public String take() {

        LOCK.lock();

        try {
            while(Q.isEmpty()) {
                log("[take] 큐에 데이터 없음, 소비자 대기" );
                try {
                    CONSUMER_COND.await();
                    log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = Q.poll();
            log("[take] 소비자 데이터 획득, PRODUCER_COND 호출");
            PRODUCER_COND.signal();
            return data;
        } finally {
            LOCK.unlock();
        }
    }

    @Override
    public String toString() {
        return Q.toString();
    }
}
