package thread.control.yield;

import thread.start.HelloRunnable;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1.empty
                // sleep(1) //지정한 ms 만큼 wait 후 깨어남
                /**
                 *  yeild의 경우 잠깐 쉬기는 하지만 sleep 처럼 wait 상태로 들어가지는 않고 Runnable 상태를 유지한다.
                 */
                Thread.yield();
            }
        }
    }
}
