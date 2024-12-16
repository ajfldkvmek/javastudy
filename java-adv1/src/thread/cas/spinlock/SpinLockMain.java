package thread.cas.spinlock;

import static util.MyLogger.log;

public class SpinLockMain {

    public static void main(String[] args) {

        /**
         *  cpu 사이클이 매우 일찍 끝나는 ( 단순 연산, 자료구조의 데이터 입출력 등 10ms? 이하의 짧은 연산의 경우에만 사용해야함 )
         *
         */
//        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();
        Runnable task = new Runnable() {

            @Override
            public void run() {
                spinLock.lock();
                try{
                    //critical logic
                    log("비즈니스 로직 실행");
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
