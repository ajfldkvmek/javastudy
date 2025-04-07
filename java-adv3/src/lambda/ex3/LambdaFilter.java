package lambda.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaFilter {

    public static void filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if(predicate.test(i)) result.add(i);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(-3, -2, -1, 1, 2, 3, 5);

        filter(list, i -> i < 0);
        filter(list, i -> i % 2 == 0);
    }
}
