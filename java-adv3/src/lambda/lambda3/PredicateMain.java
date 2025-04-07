package lambda.lambda3;

import java.util.function.Predicate;

/**
 *  Function<T, Boolean> 을 사용해도 결과를 도출할 수 있지만
 *  Predicate 를 사용하면 의도를 명시적으로 드러낼 수 있다.
 *  또한 가독성과 유지보수성에서도 이점이 있다.
 */
public class PredicateMain {

    public static void main(String[] args) {

        Predicate<Integer> predicate1 = new Predicate<Integer>() {

            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println("predicate1.test(10) = " + predicate1.test(10));

        Predicate<Integer> predicate2 = integer -> integer % 2 == 0;
        System.out.println("predicate2.test(10) = " + predicate2.test(9));
    }

}
