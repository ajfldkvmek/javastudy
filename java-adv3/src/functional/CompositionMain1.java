package functional;

import java.util.function.Function;

public class CompositionMain1 {

    public static void main(String[] args) {

        // 1. x 를 입력받아 x * x 를 하는 함수
        Function<Integer, Integer> square = x -> x * x;

        // 2. x 를 입력받아 x + 1 하는 함수
        Function<Integer, Integer> add = x -> x + 1;

        // 함수 합성
        // 1. composition
        // 이렇게 composition 으로 조합한 함수는 여러곳에서 사용할 수 있다.
        // 함수의 적용순서는 안에 있는 것이 먼저 실행된다.

        System.out.println("composiition()======================================");
        Function<Integer, Integer> newFunction1 = square.compose(add);
        Function<Integer, Integer> newFunction2 = add.compose(square);

        System.out.println("newFunction1.apply(2) = " + newFunction1.apply(2));
        System.out.println("newFunction2.apply(2) = " + newFunction2.apply(2));

        // 2. andThen()
        // andThen() 은 앞에서 부터 순차적으로 실행된다.
        System.out.println("andThen()======================================");
        Function<Integer, Integer> newFunction3 = square.andThen(add);
        Function<Integer, Integer> newFunction4 = add.andThen(square);
        System.out.println("newFunction3.apply(2) = " + newFunction3.apply(2));
        System.out.println("newFunction4.apply(2) = " + newFunction4.apply(2));



    }
}
