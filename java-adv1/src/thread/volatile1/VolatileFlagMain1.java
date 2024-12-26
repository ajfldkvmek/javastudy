package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 *  자바에서 volatile 은 예약어이 이기 때문에 사용불가임
 *  따라사 패키지명을 volatile1로 지정
 */
public class VolatileFlagMain1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);

        t.start();
        sleep(1000);

        /**
         *  이렇게 하게되면 한 스레드에서 변경한 값이 다른 스레드에서 보이지 않게되는
         *  메모리 가시성 문제가 발생한다.
         *  
         *  이는 캐시메모리를 사용할 경우 발생하는 문제로
         *  캐시메모리를 사용할 경우 속도적인면에서는 장점을 얻을 수 있지만
         *  같은 데이터를 보며 작업하여 정확성을 높이기 위해서는 좋지않다
         *  이를 해결하기위해선 어떻게 하여야할까?
         *
         *  이 때 사용한는 것이 자바의 volatile 키워드이다
         */
        log("runFlag를 false로 변경시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

        boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");

            while(runFlag){
                // runFlag 가 false 로 변하면 break;
            }
            log("task 완료");
        }
    }
}
