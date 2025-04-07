package lambda.lambda3;

public class RunnableMain {

    public static void main(String[] args) {

        //익명클래스
        Runnable runnable1 = new Runnable() {
            public void run() {
                System.out.println("Hello Runnable");
            }
        };
        runnable1.run();

        //lambda
        Runnable runnable2 = () -> System.out.println("Hello Runnable");
        runnable2.run();

    }
}
