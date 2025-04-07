package lambda.lambda3;

import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {

        //익명클래스
        Consumer<String> consumer1 = new Consumer<>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Hello consumer");

        //lambda
        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("Hello consumer");

        //lambda + Method Reference
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("Hello consumer");
    }

}
