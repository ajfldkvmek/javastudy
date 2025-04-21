package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {

    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(
                new EmailNotifier(),
                new SmsNotifier(),
                new AppPushNotifier()
        );
//        for (Notifier notifier : notifiers) {
//            notifier.notify("서비스 가입을 환영합니다!!!");
//        }
        // 아래와 같이 람다식으로도 가능하다.
        notifiers.forEach(n -> n.notify("서비스 가입을 환영합니다!!!"));

        // 스케줄 기능 추가
        LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);//하루 뒤에
        notifiers.forEach(n -> {
            n.scheduleNotification("Hello!", plus1Days);
        });
    }
}
