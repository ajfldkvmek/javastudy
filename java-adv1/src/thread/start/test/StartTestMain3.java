package thread.start.test;

import static util.MyLogger.log;

public class StartTestMain3 {

    public static void main(String[] args) {
        //두 번째 파라메터는 스레드의 이름임
        Thread thread = new Thread(
                new Runnable(){
                    @Override
                    public void run(){
                        for (int i = 1; i <= 5; i++) {
                            log("value " + i);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, "counter");
        thread.start();
    }


}
