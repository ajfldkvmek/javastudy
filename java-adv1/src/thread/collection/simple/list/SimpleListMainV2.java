package thread.collection.simple.list;

import static util.MyLogger.log;

public class SimpleListMainV2 {

    /**
     *
     * @param args
     * @throws InterruptedException
     *
     * BasicList 를 직접사용하지 않고
     * SyncList 가 대신 BasicList 를 사욯 (proxy) 하여
     * Collection 에 접근
     *
     * 즉 원본 인터페이스인 BasicList 의 변경없이
     * SyncList 를 통해 스레드를 안전하게 관리할 수 있는 것!
     *
     * 이게 객체지향 패턴중 하나인 proxy 패턴이다
     *
     * proxy 패턴이란
     * 어떤 객체에 대한 접근을 제어하기 위해 그 객체의 대리인 또는 인터페이스 역할을 하는 객체를 제공하는 패턴
     */
    public static void main(String[] args) throws InterruptedException {
        //test(new BasicList());
        //test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        // A를 리스트에 저장하는 코드
        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };

        // B를 리스트에 저장하는 코드
        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread thread1 = new Thread(addA, "Thread-1");
        Thread thread2 = new Thread(addB, "Thread-2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log(list);
    }
}
