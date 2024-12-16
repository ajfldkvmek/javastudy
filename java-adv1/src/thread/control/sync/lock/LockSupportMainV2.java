package thread.control.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 *  LockSupport 의 대표적인 기능은
 *  쓰레드를 Waiting 상태로 변경하는 것이다.
 *  Waiting 상태가 된 쓰레드는 누가 깨워주기 전까지 cpu 실행 스케줄링에 들어가지 않는다.
 *
 *
 *  park() : 스레드를 waiting 상태로 변경
 *
 *  parkNanos(nanos) : 스레드를 나노초 동안만 TIMED-WAITING 상태로 변경한다.
 *   -> 지정한 나노초가 지나면 스레드의 상태는 다시 Runnable 상태가 된다.
 *
 *  unpark(thread) : waiting 상태의 스레드를 Runnable 로 변경한다.
 *
 *  LockSupport 를 사용하면 synchronized 에서 발생하는 무한대기의 단점을 개선할 수 있다.
 *  synchronized는 interrupt 를 불가능하고
 *  park() 나 parkNanos() 는 interrupt 를 사용할 수 있기 때문
 *  하지만 이 기능을 사용하기 위해서는 직접 구현을 해야한다.
 *
 *  BUT!!!!!!!!!!!!!!!!!!!!!
 *  자바는 이미
 *  Lock 인터페이스와 ReentrantLock 구현체로 이러한 기능들을 다 구현해놓았다.
 *  즉 LockSupport를 직접 만들일은 없다!
 *
 */
public class LockSupportMainV2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        // 잠시 대기사여 Thread-1 이 park 상태에 빠질 시간을 준다.
        sleep(100);
        log("Thread-1 state::" + thread1.getState());
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            // 파라메터로 던져준 나노초만큼 대기 후 깨어남
            LockSupport.parkNanos(2_000_000_000);
            log("park 종료, state::" + Thread.currentThread().getState());
            log("인터럽트 상태::" + Thread.currentThread().isInterrupted());
        }
    }
}
