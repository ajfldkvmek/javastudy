package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
//        System.out.println("start value::" + ai.get());

        //incrementAndGet() 직접구현 -
        int resValue1 = incrementAndGet(ai);
        System.out.println("resValue1::" + resValue1);

        int resValue2 = incrementAndGet(ai);
        System.out.println("resValue2::" + resValue2);

    }

    private static int incrementAndGet(AtomicInteger ai) {
        int getValue;
        boolean result;

        do {
            getValue = ai.get();
            log("getValue::" + getValue);
            result = ai.compareAndSet(getValue, getValue + 1);
            log("result::" + result);
        } while(!result);

        return getValue+1;
    }
}
