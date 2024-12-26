package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV2 {

    public static void main(String[] args) {
        log("Start");

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "thread1");
        Thread thread2 = new Thread(sumTask2, "thread2");

        thread1.start();
        thread2.start();

        //정확한 대기는 불가능 -> 이를 위해 join 메소드를 사용한다
        log("main 스레드 sleep()");
        sleep(3000);
        log("main 스레드 wake");

        log("task1.result::"+sumTask1.result);
        log("task2.result::"+sumTask2.result);

        log("end");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            int sum = 0;
            for(int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업완료 result::" + result);
        }
    }

}
