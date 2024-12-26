package thread.control.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV5 implements BankAccount {

    private int balance;
    private final Lock lock = new ReentrantLock();
    public BankAccountV5(int initialBalance) {
        balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래시작: " + getClass().getSimpleName());

//        lock.lock(); // RentransLock 이용하여 lock 걸기

        if(!lock.tryLock()){
            log("[진입실패] 이미 처리중인 작업이 있습니다");
            return false;
        }

        try{
            log("[검증시작] 출금액: " + amount + ", 잔액: " + balance);
            //잔고가 출금액보다 적으면 return false, 많으면 진행
            if(balance < amount) {
                log("[검증실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            log("[검증완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000); //출금에 걸리는 시간

            balance = balance - amount;
            log("[출금완료] 출금액: " + amount + ", 잔액: " + balance);
        } finally {
            lock.unlock();
            //lock 을 하면 반드시 unlock를 해야한다.
            //만약 lock 이 Exception 을 발생하더라도 unlcok 는 반드시 발생해야 하기 때문에 finally 를 사용
        }
        // 이렇게 하게되면 lock ~ unlock 까지의 코드블럭이 임계영역이된다.

        log("거래종료: " + getClass().getSimpleName());
        return true;

    }

    @Override
    public int getBalance() {
        lock.lock();
        try{
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
