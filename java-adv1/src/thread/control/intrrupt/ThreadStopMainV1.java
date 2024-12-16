package thread.control.intrrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);

        /**
         *  이 방법대로 하게되면 sleep 으로 지정한 시간만큼 쓰레드가 대기상태에 있다가 while 문을 실행하게됨
         *  그에 따라 즉각적인 반응이 어려움
         */
        log("작업 중단 지시 runFlag=false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;


        @Override
        public void run() {
            while(runFlag){
                log("작업중");
                sleep(3000);
            }
        }
    }
}
