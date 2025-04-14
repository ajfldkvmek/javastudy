package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Collectors3Group {

    public static void main(String[] args) {
        // 첫 글 자 알파벳을 기준으로 그룹화
        List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");

        Map<String, List<String>> grouped = names.stream()
                .collect(groupingBy(name -> name.substring(0, 1)));
        System.out.println("grouped = " + grouped);

        //짝수 홀수 구분
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> evens = integers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("evens = " + evens);


    }
}
