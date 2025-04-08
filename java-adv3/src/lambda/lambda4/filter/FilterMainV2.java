package lambda.lambda4.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenList = filter(numbers, n -> n % 2 == 0);
        List<Integer> oddList = filter(numbers, n -> n % 2 != 0);

        System.out.println("evenList = " + evenList);
        System.out.println("oddList = " + oddList);

    }

    private static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

}
