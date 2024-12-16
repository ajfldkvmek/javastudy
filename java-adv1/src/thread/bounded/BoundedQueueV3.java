package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 *  notify() wait() 의 경우...
 *  같은 종류의 쓰레드를 깨울 때 비효율이 발생한다.
 *  즉 consumer 가 consumer 를 깨우거나
 *  producer 가 producer 를 깨울 때 매우 비효율적인다.
 *  반대로 서로 다른 스레드를 깨울 경우 이런 단점은 발생하지 않는다.
 *
 *  notify 의 또 다른 문제는 어떤 스레드가 깨어날 지 모른다는 것이다.
 *  이 때문에 starvation 문제가 발생할 수 있다.
 *  이를 해결하기 위해 notifyAll() 을 사용하는 방법이 있다.
 *
 *  하지만 notifyAll() 도 기아는 해결하지만 비효율은 막지 못한다.
 */
public class BoundedQueueV3 implements BoundedQueue{

    private final Queue<String> Q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if(Q.size() == max) {
            log("[put] 큐가 가득 참, 소비자대기::" + data);
            try {
                wait(); //Object 클래스에서 제공하는 메소드 - RUNNABLE -> WAITING, 락 반납 <- 다른 스레드가 깨어날 수 있음
                log("[put] 생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Q.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify(); //대기 스레드, WAIT -> BLOCKED

    }

    @Override
    public synchronized String take() {
        if(Q.isEmpty()) {
            log("[take] 큐에 데이터 없음, 소비자 대기" );
            try {
                wait();
                log("[take] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = Q.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // notify() 를 만나면 wait() 상태에 있던 쓰레드가 깨어남 ( WAIT -> BLOCKED)
        //notifyAll() //모든 대기 스레드 - WAIT -> BLOCKE
        return data;
    }

    
    //원칙은 synchronized 해야하지만 예제라 생략
    @Override
    public String toString() {
        return Q.toString();
    }
}
