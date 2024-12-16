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
 *  unpark(thread) : waiting 상태의 스레드를 Runnable로 변경한다.
 *
 */
public class LockSupportMainV1 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        // 잠시 대기사여 Thread-1 이 park 상태에 빠질 시간을 준다.
        sleep(100);

        log("Thread-1 state::" + thread1.getState());

        log("main -> unpark(Thread-1)");
        LockSupport.unpark(thread1);
//        아래처럼 interrupt() 를 사용하여도 RUNNABLE 상태가 될 수 있다!
//        thread1.interrupt();

    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state::" + Thread.currentThread().getState());
            log("인터럽트 상태::" + Thread.currentThread().isInterrupted());
        }
    }
}
