package lambda.lambda3.bi;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
    매개변수가 두 개 이상 필요한 경우  BiXxx 를 사용하면 된다
 */
public class BiMain {

    public static void main(String[] args) {

//        BiFunction<Integer, Integer, Integer> add = Integer::sum; 는 아래와 같다
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("add.apply(1,2) = " + add.apply(1, 2));


        BiConsumer<String, Integer> repeat = (c, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        };
        repeat.accept("*", 7);

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("isGreater.test(1, 2) = " + isGreater.test(1, 2));

    }

    //입력값이 세개 이상이라면?? -> 기본적인 함수형 인터페이스에서는 이런 기능을 제공하지 않기때문에 직접 만들어줘야한다.
    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
