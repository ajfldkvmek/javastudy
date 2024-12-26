package thread.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
//        test(new VolatileInteger());
//        test(new BasicInteger());
//        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable runnable = new Runnable(){
            public void run(){
                /**
                 *  //잠깐 쉬었다 실행 -> 간단한 연산은 너무 빨리 실행되기 떄문에 스레드가 동시에 접근하지않는 경우도 생김
                 *  그렇다면 이 문제는 volatile 을 적용하면 해결될까? -> 응 아니야~
                 *  volatile 을 사용하면 캐시메모리에 접근하지 않고 메인메모리에 접근함
                 *
                 *  하지만 이를 사용함에도 이런 문제가 발생하는 이유는 단순히 캐시메모리를 무시할 뿐
                 *  연산 자체가 나뉘어 있는 것이 아니기 때문임
                 *
                 *  이를 위해서는 임계영역을 만들어주어서 연산을 실행해 주어야함
                 */
                sleep(10); //잠깐 쉬었다 실행 -> 간단한 연산은 너무 빨리 실행되기 떄문에 스레드가 동시에 접근하지않는 경우도 생김
                incrementInteger.increment();
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        log(incrementInteger.getClass().getSimpleName() + " result::" + result);
    }
}
