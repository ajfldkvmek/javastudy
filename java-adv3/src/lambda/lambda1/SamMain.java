package lambda.lambda1;

public class SamMain {

    public static void main(String[] args) {
        SamInterface sam = () -> System.out.println("Hello Sam");
        sam.run();
    }

}
