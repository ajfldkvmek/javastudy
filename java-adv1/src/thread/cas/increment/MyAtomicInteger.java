package thread.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger{

    /**
     *  AtomicInteger 는 멀티스레드 상황에 안전하고 또 다양한 연산을 제공항
     *  AtomicInteger 이외에도
     *  AtomicInteger, AtomicLog, AtomicBoolean 등 다양한 AtomicXXX 클래스가 존재한다
     */
    AtomicInteger atomicInteger = new AtomicInteger(0); //초기값을 줄 수 있다!
    @Override
    public void increment() {
        //이전에 직접 구현한 동시성 제어와 관련된 기능들이 다 구현되어있다!
        atomicInteger.incrementAndGet();
    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
