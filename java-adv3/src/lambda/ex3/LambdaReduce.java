package lambda.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class LambdaReduce {

    public static  int reducer(List<Integer> list, Integer init, BinaryOperator<Integer> binaryOperator) {
        Integer result = init;
        for (Integer i : list) {
            result = binaryOperator.apply(result, i);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        int sum = reducer(list, 0, Integer::sum);
        int mul = reducer(list, 1, (a, b) -> a * b);

        System.out.println("누적합: " + sum);
        System.out.println("누적곱: " + mul);
    }
}
