package lambda.lambda4.mystream;

import lambda.lambda4.filter.GenericFilter;
import lambda.lambda4.map.GenericMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1_Number {

    //짝수만 남기고 그 값들의 2배를 반환
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);

    }

    private static List<Integer> lambda(List<Integer> numbers) {
        return GenericMapper.map(
                GenericFilter.filter(numbers, (num) -> num % 2 == 0),
                (num) -> num * 2);
//        List<Integer> filter = GenericFilter.filter(numbers, (num) -> num % 2 == 0);
//        return GenericMapper.map(filter, (num) -> num * 2);
    }

    private static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 == 0) {
                result.add(number*2);
            }
        }
        return result;
    }
}
