package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {

    public static void main(String[] args) {

        log("main() start");

        //익명 클래스로 생성한 Runnable - 객체 생성없이 바로 전달
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();

        log("main() end");


    }

}
