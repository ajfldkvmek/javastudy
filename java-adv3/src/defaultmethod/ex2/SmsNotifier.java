package defaultmethod.ex2;

public class SmsNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("SMS Notifier: " + message);
    }
}
