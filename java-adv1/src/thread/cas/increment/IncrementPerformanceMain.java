package thread.cas.increment;

public class IncrementPerformanceMain {

    public static long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new VolatileInteger());
        test(new BasicInteger()); //가장빠름 - 시스템 캐시에 접근하기 때문 그러나 멀티스레드 환경에서는...
        test(new SyncInteger());
        test(new MyAtomicInteger()); //이놈은 lock을 사용하지 않기 때문에 연산이 좀 더 빠르다
    }

    private static void test(IncrementInteger incrementInteger) {

        long startTs = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }
        long endTs = System.currentTimeMillis();

        System.out.println(incrementInteger.getClass().getSimpleName() + " :ms = " + (endTs - startTs));
   }
}
