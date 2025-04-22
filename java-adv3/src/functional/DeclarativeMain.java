package functional;

import java.util.ArrayList;
import java.util.List;

// 짝수면 값을 제곱해라
public class DeclarativeMain {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 명령형: for 문과 조건 검사로 처리
        List<Integer> result1 = new ArrayList<>();
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                result1.add(i * i);
            }
        }
        System.out.println("Imperative Result: " + result1);

        // 선언형
        List<Integer> result2 = numbers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .toList();
        System.out.println("Derivative Result: " + result2);

        System.out.println("Origin: " + numbers);
    }
}
