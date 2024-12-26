package thread.start;

import util.MyLogger;

import static util.MyLogger.*;

public class ManyThreadRunnableV1 {

    public static void main(String[] args) {
        log("main() start");
        /**
         *  아래와 같이 같은 인스턴스를 전달하게되면
         *  세 개의 쓰레드는 모두 같은 인스턴스에 있는 run()을 실행한다.
         */
        HelloRunnable runnable = new HelloRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();

        log("main() end");

    }
}
