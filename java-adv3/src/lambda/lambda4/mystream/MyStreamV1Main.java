package lambda.lambda4.mystream;

import java.util.List;

public class MyStreamV1Main {

    public static void main(String[] args) {
        //짝수만 남기고 *2
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        returnValue(numbers);
    }

    public static void returnValue(List<Integer> numbers) {
//        MyStreamV1 stream = new MyStreamV1(numbers);
//        MyStreamV1 filteredStream = stream.filter(number -> number % 2 == 0);
//        System.out.println("filteredStream = " + filteredStream.toList());
//
//        MyStreamV1 map = filteredStream.map(number -> number * 2);
//        System.out.println("map.toList() = " + map.toList());

        MyStreamV1 stream = new MyStreamV1(numbers).filter(number -> number % 2 == 0).map(number -> number * number);

        System.out.println("stream = " + stream.toList());
    }
}
