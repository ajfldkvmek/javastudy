package thread.control.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {

//        BankAccount account = new BankAccountV1(1000);
//        BankAccount account = new BankAccountV2(1000);
//        BankAccount account = new BankAccountV3(1000);
//        BankAccount account = new BankAccountV4(1000);
        BankAccount account = new BankAccountV5(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
        t1.start();
        t2.start();

        sleep(500); //검증완료까지 잠시 대기
        log("t1 state: " + t1.getState());
        log("t2 state: " + t1.getState());

        log("최종잔액: " + account.getBalance());
        log("최종잔액: " + account.getBalance());

        t1.join();
        t2.join();
    }
}
