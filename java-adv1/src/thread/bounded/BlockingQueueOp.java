package thread.bounded;

/**
 *  자바에서는 쓰레드관리를 위해
 *  java.util.concurrnet.BlockingQueue 라는 특별한 멀티스레드 자료구조를 제공한다.
 *  이는 말 그대로 쓰레드를 차단할 수 있는 큐 이다
 *
 *  데이터 추가 차단: 큐가 가득차면 데이터 추가작업을(put) 시도하는 스레드가 공간이 생길 떄 까지 차단
 *  데이터 획득 차단: 큐가 비어있으면 획득작업(take)을 시도하는 스레드는 큐에 데이터가 들어올 떄 까지 차단
 *
 */
public class BlockingQueueOp {
}
