package lambda.lambda4.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //String to Integer
        List<Integer> numbers1 = mapStringToInteger(list);
        System.out.println("numbers = " + numbers1);

        //length of String
        List<Integer> numbers2 = mapStringToLength(list);
        System.out.println("length = " + numbers2);
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            numbers.add(s.length());
        }
        return numbers;
    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            Integer i = Integer.valueOf(s);
            numbers.add(i);
        }
        return numbers;
    }
}
