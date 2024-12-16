package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_3 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    public void put(String data) {
        boolean result = false;
        try {
            result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
            log("저장 시도 결과::" + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     *
     * offer(data) 는 성공하면 true를 반환하고, 버퍼가 가득차면 false 를 반환\
     * poll() 버퍼에 데이터가 없으면 즉시 null 을 반환한다.
     *
     * offer 또한 대기시간 설정가능
     * 인터럽트도 설정 가능
     */

    @Override
    public String take() {
        try {
            return queue.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
