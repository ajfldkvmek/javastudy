package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {
    /**
     *  이 로직은 동시에 락을 획득하고 반납한다.
     *
     */
    private volatile boolean lock = false; // lock 이 있는지 확인하기위한 flag

    public void lock(){
        log("락 획득 시도");
        while (true) {
            if (!lock) { //락 여부 확인
                sleep(100);// 문제상황확인요 스레드 대기
                lock = true; //  락 획득하면 break
                break;
            } else {
                // 락을 획득할 때 까지 스핀 대기
                log("락 획득 실패 - 스핀 대기");
            }
        }
        log("락 획득 실패 - 스핀 대기");
    }

    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }

}
