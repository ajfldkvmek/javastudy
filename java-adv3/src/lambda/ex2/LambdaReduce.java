package lambda.ex2;

import java.util.Arrays;
import java.util.List;

public class LambdaReduce {

    @FunctionalInterface
    public interface MyReducer<T> {
        T reduce(T t1, T t2);
    }

    public static <T> T reducer(List<T> list, T init, MyReducer<T> myReducer) {
        T result = init;
        for (T t : list) {
            result = myReducer.reduce(result, t);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Integer sum = reducer(list, 0, Integer::sum);
        Integer mul = reducer(list, 1, (a, b) -> a * b);

        System.out.println("누적합: " + sum);
        System.out.println("누적곱: " + mul);
    }
}
