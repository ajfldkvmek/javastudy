package lambda.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaFilter2 {

    public interface MyPredicate {
        boolean test(Integer i);
    }

    public static void filter(List<Integer> list, MyPredicate myPredicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if(myPredicate.test(i)) result.add(i);
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
