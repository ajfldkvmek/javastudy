package thread.cas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CasMainV3 {

    /**
     *  CAS 연산의 핵심은 내가 하려던 것이 이미 변경되어 있으면 실행하지 않겠다는 것
     */
    private static final int THREAD_COUNT = 100;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value::" + atomicInteger.get());

        Runnable runnable = new Runnable() {
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " result::" + result);

    }

    private static int incrementAndGet(AtomicInteger ai) {
        int getValue;
        boolean result;

        do {
            getValue = ai.get();
            sleep(100); //스레드 동시실행을 위한 sleep();

            log("getValue::" + getValue);
            result = ai.compareAndSet(getValue, getValue + 1);
            log("result::" + result);
        } while(!result);

        return getValue+1;
    }
}