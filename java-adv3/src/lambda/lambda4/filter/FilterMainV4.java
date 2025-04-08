package lambda.lambda4.filter;

import java.util.List;

public class FilterMainV4 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenList = IntegerFilter.filter(numbers, n -> n % 2 == 0);
        List<Integer> oddList = IntegerFilter.filter(numbers, n -> n % 2 != 0);

        System.out.println("evenList = " + evenList);
        System.out.println("oddList = " + oddList);

    }

}
