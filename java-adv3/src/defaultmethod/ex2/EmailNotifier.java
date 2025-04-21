package defaultmethod.ex2;

import java.time.LocalDateTime;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Email Notifier: " + message);
    }

    @Override
    public void scheduleNotification(String message, LocalDateTime time) {
        System.out.println("Email Notifier Scheduling: " + message + ", time: " + time);
    }
}
