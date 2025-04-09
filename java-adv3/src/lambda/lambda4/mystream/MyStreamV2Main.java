package lambda.lambda4.mystream;

import java.util.List;

public class MyStreamV2Main {

    public static void main(String[] args) {
        //짝수만 남기고 *2
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = MyStreamV2.of(numbers).filter(number -> number % 2 == 0)
                .map(number -> number * 2).toList();

        System.out.println("result = " + result);
    }

}
