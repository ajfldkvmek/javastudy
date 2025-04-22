package functional;

import java.util.function.Function;

public class CompositionMain2 {

    public static void main(String[] args) {

        // 1. String -> Integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // 2. Integer -> Integer ( square )
        Function<Integer, Integer> square = x -> x * x;

        // 3. Integer -> String
        Function<Integer, String> toString = x -> "결과: " + x;

        // compose or andThen
        // parseInt -> square -> toString
        Function<String, String> finalFunc = parseInt
                .andThen(square)
                .andThen(toString);
        String result2 = finalFunc.apply("5");
        System.out.println("result2 = " + result2);

        Function<String, String> finalFunc2 = toString
                .compose(square)
                .compose(parseInt);
        String result3 = finalFunc2.apply("5");
        System.out.println("result3 = " + result3);

    }
}
