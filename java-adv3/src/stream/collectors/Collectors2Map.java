package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Collectors2Map {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Orange", "Pear", "Grape")
                .collect(toMap(name -> name, String::length));
        System.out.println("map1 = " + map1);

//        아래와 같이 중복된 값이 있을 때 map 을 생성하게 되면 맵 중복 오류 발생
//        Map<String, Integer> map = Stream.of("Apple", "Banana", "Apple"s)
//                .collect(toMap(name -> name, String::length));
//        System.out.println("map = " + map);

        //키 중복 대한 (병합)
        Map<String, Integer> map2 = Stream.of("Apple", "Banana", "Apple")
                .collect(toMap(
                        name -> name,
                        String::length,
                        (oldValue, newValue) -> oldValue + newValue) //merge function: 이 코드의 경우  중복될 경우 기존 값 + 새 값
                );
        System.out.println("map2 = " + map2);

        //map 타입 지정
        Map<String, Integer> map3 = Stream.of("Apple", "Banana", "Apple")
                .collect(toMap(
                        name -> name,
                        String::length,
                        (oldValue, newValue) -> oldValue + newValue, //merge function: 이 코드의 경우  중복될 경우 기존 값 + 새 값
                        LinkedHashMap::new)
                );
        System.out.println("map3 = " + map3);
        System.out.println("map3.getClass() = " + map3.getClass());
    }
}
