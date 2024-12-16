package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    public void put(String data) {
       boolean result =  queue.offer(data);
        log("저장 시도 결과::" + result);
    }

    /**
     *
     * @return
     *
     * offer(data) 는 성공하면 true를 반환하고, 버퍼가 가득차면 false 를 반환\
     * poll() 버퍼에 데이터가 없으면 즉시 null 을 반환한다.
     */

    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
