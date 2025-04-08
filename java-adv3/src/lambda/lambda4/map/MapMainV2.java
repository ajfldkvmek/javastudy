package lambda.lambda4.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //String to Integer
        List<Integer> numbers1 = stringToInteger(list, Integer::parseInt);
        System.out.println("numbers1 = " + numbers1);

        //length of String
        List<Integer> numbers2 = stringToInteger(list, String::length);
        System.out.println("numbers2 = " + numbers2);
    }

    public static List<Integer> stringToInteger(List<String> list, Function<String, Integer> function) {
        List<Integer> result = new ArrayList<>();

        for (String s : list) {
            result.add(function.apply(s));
        }
        return result;
    }
}
