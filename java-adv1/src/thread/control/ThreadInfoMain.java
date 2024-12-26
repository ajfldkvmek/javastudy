package thread.control;

import thread.start.HelloRunnable;
import thread.start.HelloThread;
import util.MyLogger;

import static util.MyLogger.*;

public class ThreadInfoMain {

    public static void main(String[] args) {
        /**
         *  threadName 은 중복이 되지만
         *  threadId 는 중복이 불가
         *  priority 가 높으면 더 높은 확률로 더 자주 실행됨
         */
        Thread mainThread = Thread.currentThread();
        log("mainThread" + mainThread);
        log("mainThread.threadId()::" + mainThread.threadId());
        log("mainThread.getName()::" + mainThread.getName());
        log("mainThread.getPriority()::" + mainThread.getPriority());
        log("mainThread.getThreadGroup()::" + mainThread.getThreadGroup());
        log("mainThread.getState()::" +  mainThread.getState());

        System.out.println("==========================================================");

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread" + myThread);
        log("myThread.threadId()::" + myThread.threadId());
        log("myThread.getName()::" + myThread.getName());
        log("myThread.getPriority()::" + myThread.getPriority());
        log("myThread.getThreadGroup()::" + myThread.getThreadGroup());
        log("myThread.getState()::" +  myThread.getState()); //NEW 는 생성만하고 아직 실행하지 않은 상태

    }

}
