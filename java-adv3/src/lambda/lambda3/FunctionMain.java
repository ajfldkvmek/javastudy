package lambda.lambda3;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        //익명클래스
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("function1 = " + function1.apply("hello"));

        //lambda
        Function<String, Integer> function2 = s -> s.length();
        System.out.println("function2 = " + function2.apply("hello"));

        Function<String, Integer> function3 = String::length;
        System.out.println("function3 = " + function3.apply("hello"));
    }
}
