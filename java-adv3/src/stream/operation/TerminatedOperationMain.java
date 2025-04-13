package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminatedOperationMain {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        //Collectors 는 추후 자세히 정리 - 복잡한 수집이 필요할 때 사용
        System.out.println("1. collect - list 수집");
        System.out.println("짝수 리스트 수집---------------------------");
        List<Integer> evenList = integers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("evenList = " + evenList);


        System.out.println("홀수 리스트 수집---------------------------");
        List<Integer> oddList = integers.stream()
                .filter(i -> i % 2 != 0)
                .toList(); // Collectors.toList() 는 이와같이 간단하게 변경할 수 있음(since java16)
        System.out.println("oddList = " + oddList);


        System.out.println("to Array - 배열로 변환");
        Integer[] array1 = integers.stream()
                .filter(i -> i % 2 != 0)
                .toArray(Integer[]::new);
        System.out.println("array1 = " + Arrays.toString(array1));

        System.out.println("4. forEach - 각 요소를 처리"); //반환값 없음
        integers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("5. count - 요소 개수");
        long count = integers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("5보다 큰 숫자의 수 = " + count);


        System.out.println("6. reduce - 요소들의 합");
        System.out.println("초기값이 없는 reduce");
        Optional<Integer> reduce1 = integers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("합계(초기값 없음) = " + reduce1.get());
        //만약 초기값이 없을 때, 전달된 값이 비어있을 경우를 대비해서 Optional 이 있는 것이다
        //만약 초기값이 없을 때 전달된 값 또한 없을 경우 Optional.empty() 를 반환한다.

        System.out.println("초기값이 있는 reduce");
        int reduce2 = integers.stream()
                .reduce(100, (a, b) -> a + b);
        System.out.println("합계(초기값 100) = " + reduce2);


        System.out.println("7. min");
        Optional<Integer> min = integers.stream()
                .min(Integer::compareTo);
//                .min((before, after) -> before.compareTo(after));
        System.out.println("최솟값 = " + min.get());

        System.out.println("8. max");
        Optional<Integer> max = integers.stream()
                .max(Integer::compareTo);
//                .min((before, after) -> before.compareTo(after));
        System.out.println("최댓값 = " + max.get());


        //findFirst 또한 일치하는 결과가 없을 수 있기 때문에 Optional로 제공한다.
        System.out.println("9. findFirst - 첫번째 요소 뽑기");
        Integer i1 = integers.stream()
                .filter(i -> i > 5)
                .findFirst().get();
        System.out.println("5보다 큰 첫번쨰 숫자 = " + i1);


        // findAny는 순서에 상관없이 값을 찾을 때( ex. 멀티스레드의 경우 )
        System.out.println("10. findAny - 아무 요소나 찾기");
        Integer i2 = integers.stream()
                .filter(i -> i > 5)
                .findAny().get();
        System.out.println("5보다 큰 첫번쨰 숫자 = " + i2);


        System.out.println("11. anyMatch - 조건을 만족하는 요소의 존재 여부");
        boolean b = integers.stream()
                .anyMatch(i -> i % 2 == 0);
        System.out.println("만족? = " + b);

        System.out.println("12. allMatch - 모든 요소가 조건을 만족하나");
        boolean a = integers.stream()
                .allMatch(i -> i > 0);
        System.out.println("모두 만족? = " + a);

        System.out.println("13. nonMatch - 조건을 만족하는 요소가 없나?");
        boolean no =  integers.stream()
                .noneMatch(i -> i < 0);
        System.out.println("음수가 없나? = " + no);
    }

}
