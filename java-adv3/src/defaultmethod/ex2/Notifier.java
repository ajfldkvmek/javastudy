package defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {

    // 알림을 보내는 기능
    void notify(String message);

    // 스케줄링 기능 추가 (신규)
    // 이렇게 인터페이스에 변경이 있을 때 이 인터페이스의 구현 클래스들을 모두 수정해야하는 번거로움이 있음 (호환성 맞추기 매우 힘들어짐)
    // 이 경우 아래처럼 default 메소드(since java8)로 선언후 기본구현을 하면된다. 이 경우에는 모든 구현 클래스에 수정을 할 필요가 사라진다.
    // default 메소드는 하위호환을 위한 기능이나, 공통으로 쓰기 쉬운 간단한 로직을 제공하는 정도가 이상적이다.
    // 가능한 로직의 구현은 구현클래스나 별도 클래스에 두도록 하자
    // 인터페이스를 다중상속 했을 때 같은 이름의 default 메소드가 있을 경우 충돌이 발생한다.
    // 이 경우 직접 구현을 하거나 어떤 메소드를 사용할 것인지 명시해주어야 한다.
    // ex)
    // 1. 직접구현
    // 2. ClassA.super.methodName();
    // 여러 차례 호출 시 상태에 따라 동작이 달라지는 것은 지양해야함(default 메소드에는 상태를 두면 안된다)
    default void scheduleNotification(String message, LocalDateTime time) {
        System.out.println("basic schedule notification: " + message + ", time: " + time);
    }

}