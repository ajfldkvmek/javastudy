package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");

        SumTask sumTask1 = new SumTask(1, 50);
//        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "thread1");
//        Thread thread2 = new Thread(sumTask2, "thread2");

        thread1.start();
//        thread2.start();

        //스레드가 종료될 때 까지 대기
        //join 은 특정시간을 지정할 수도 있다.
        //이때 main thread는 waiting 이 아니라 timed-wating이 된다
        //wating은 무기한 대기
        //timed-waiting 은 특정시간만큼 대기
        log("main 스레드가 스레드1 종료까지 1초대기");
        thread1.join(1000); //thread는 interruptedException 을 던진다
//        thread2.join();
        log("main 스레드 대기완료");
        
        log("task1.result::"+sumTask1.result);
//        log("task2.result::"+sumTask2.result);

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
