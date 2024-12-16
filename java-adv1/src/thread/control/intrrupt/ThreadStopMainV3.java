package thread.control.intrrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    /**
     *  isInterrupted() 의 반환값은 true/false 이다
     *
     *  이 때 interrupt 해야할 상태면 true를 반환
     *  interrupt 되고 sleep 에서 깨어나면 반환값이 false
     *
     *  즉 인터럽트를 확인한 후 인터럽트 상태가 true 라면 다시 false(정상)으로 만들 필요가 있다.
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        
        //thread.stop() -- 자바 버전에 따라 다르지만 최근버전에서는 사용하지않는 것을 권장
        //interrupted() 사용하는 것이 좋다
        thread.interrupt();
        log("work 스레드 인터럽트 상태1::" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {

            while(!Thread.currentThread().isInterrupted()){ //인터럽트 상태를 확인하는 것이지 변경하지는 않음
                log("작업중");
            }
            log("work 스레드 인터럽트 상태2::" + Thread.currentThread().isInterrupted());

            try{
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 인터럽트 발생" );
                log("work 스레드 인터럽트 상태3::" + Thread.currentThread().isInterrupted());
            }
//            log("자원 정리");
            log("자원 종료");
        }
    }
}
