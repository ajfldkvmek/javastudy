package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
public class BoundedQueueV4 implements BoundedQueue{

    private final Lock LOCK = new ReentrantLock();
    private final Condition CONDITION = LOCK.newCondition(); //스레드가 기다리는 대기집합
    private final Queue<String> Q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV4(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        LOCK.lock();
        try{
            while(Q.size() == max){
                log("[put] 큐가 가득 참, 소비자대기::" + data);
                try{
//                    wait();
                    CONDITION.await();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            Q.offer(data);
            log("[put] 생산자 데이터 저장, notify() 호출");
            notify(); //대기 스레드, WAIT -> BLOCKED
            CONDITION.signal();
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
                    CONDITION.await();
                    log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = Q.poll();
            log("[take] 소비자 데이터 획득, notify() 호출");
//            notify(); // notify() 를 만나면 wait() 상태에 있던 쓰레드가 깨어남 ( WAIT -> BLOCKED)
            //notifyAll() //모든 대기 스레드 - WAIT -> BLOCKE
            CONDITION.signal();
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
