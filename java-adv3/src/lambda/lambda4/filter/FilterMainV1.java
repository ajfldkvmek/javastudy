package lambda.lambda4.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMainV1 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = filterEvenNumber(numbers);
        System.out.println("evenNumbers = " + evenNumbers);

        List<Integer> oddNumbers = filterOddNumber(numbers);
        System.out.println("oddNumbers = " + oddNumbers);

    }

    private static List<Integer> filterEvenNumber(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer evenNumber : numbers) {
            if(evenNumber % 2 == 0) {
                evenNumbers.add(evenNumber);
            }
        }
        return evenNumbers;
    }

    private static List<Integer> filterOddNumber(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer evenNumber : numbers) {
            if(evenNumber % 2 != 0) {
                evenNumbers.add(evenNumber);
            }
        }
        return evenNumbers;
    }

}
