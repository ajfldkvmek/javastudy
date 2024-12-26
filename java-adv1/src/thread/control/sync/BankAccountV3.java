package thread.control.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(int initialBalance) {
        balance = initialBalance;
    }

    /**
     *  synchronized 를 사용하면 동기화 메서드로 생성되며 하나의 스레드만 접근이 가능하게된다.
     *  이를 Lock 이라고 하며 순서는 보장되지 않는다.(나머지는 blocked 상태)
     *  이 경우 synchronized 접근하는 변수는 가시성문제로 오류는 해결된다.(volatile 을 사용할 필요가 없어짐)
     *
     *  synchronized 의 최대 단점은 한 스레드만 실행할 수 있다는 점이다.
     *  이로인해 성능이 떨어지는 결과가 발생한다. 
     *  꼭 필요한 곳에 한정해서 사용하도록 하자
     *  
     *  자바에서는 이를 코드블럭으로 제한해서 사용할 수 있는 기능을 제공한다
     */
    @Override
    public boolean withdraw(int amount) {
        log("거래시작: " + getClass().getSimpleName());

        //하나의 스레드만 실행해야 동시성, 가시성문제를 해결할 수 있음
        //일반적으로 값을 검증하고 계산을 하여 변경이 할생할 수 있는 공유자원에 접근한 경우에는 이 영역을 제어하는 것이 매우 중요한데
        //이를 임계영역이라고 한다. 자바에서는 이를 synchronized 를 사용하여 제어할 수 있다

        synchronized(this){
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

            log("거래종료: " + getClass().getSimpleName());
            return true;
        }

    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
