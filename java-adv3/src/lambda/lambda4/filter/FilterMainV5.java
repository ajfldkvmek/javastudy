package lambda.lambda4.filter;

import java.util.List;

public class FilterMainV5 {

    public static void main(String[] args) {
        //숫자 사용 필터
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenList = GenericFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("evenList = " + evenList);

        //문자 사용 필어
        List<String> strings = List.of("a", "bb", "ccc");
        List<String> stringList = GenericFilter.filter(strings, s -> s.length() >= 2);
        System.out.println("stringList = " + stringList);
    }

}
