package lambda.lambda4.map;

import java.util.List;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "orange");

        //length of String
        List<Integer> length = GenericMapper.map( list, String::length);
        System.out.println("length = " + length);

        //to Uppercase
        List<String> upper = GenericMapper.map( list, String::toUpperCase);
        System.out.println("upper = " + upper);

        //integer to string
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<String> stars = GenericMapper.map(integers, n -> "*".repeat(n)); //repeat 메소드는 java11 부터
        List<String> stars = GenericMapper.map(integers, "*"::repeat);
        System.out.println("stars = " + stars);
    }

}
