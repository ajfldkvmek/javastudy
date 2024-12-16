package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {

    public static void main(String[] args) {
        /**
         *  compareAndSet(expectedValue, newValue);
         *  메소드는 생긴건 그렇게 생겨먹지 않았는데
         *  cpu 에 의해서 원자적으로 실행된다.
         */
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println("start value::" + ai.get());

        boolean res1 = ai.compareAndSet(0, 1);
        System.out.println("result::" + res1 + " value::" + ai.get());

        boolean res2 = ai.compareAndSet(0, 1);
        System.out.println("result::" + res2 + " value::" + ai.get());
    }
}
