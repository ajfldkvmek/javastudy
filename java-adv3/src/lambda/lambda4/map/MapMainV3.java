package lambda.lambda4.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //String to Integer
        List<Integer> numbers1 = StringToIntegerMapper.map(list, Integer::parseInt);
        System.out.println("numbers1 = " + numbers1);

        //length of String
        List<Integer> numbers2 = StringToIntegerMapper.map( list, String::length);
        System.out.println("numbers2 = " + numbers2);
    }

}
