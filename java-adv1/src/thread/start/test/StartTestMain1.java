package thread.start.test;

import util.MyLogger;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class StartTestMain1 {

    public static void main(String[] args) {

        CounterThread thread = new CounterThread();
        thread.start();

    }

    public static class CounterThread extends Thread {
        @Override
        public void run(){
            for (int i = 1; i <= 5; i++) {
                log("value " + i);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
