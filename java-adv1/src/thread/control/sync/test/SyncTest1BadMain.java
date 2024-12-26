package thread.control.sync.test;

public class SyncTest1BadMain {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("결과: " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void increment() {
            synchronized (this){
                count = count + 1;
            }
        }
    }

}