package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {

    /**
     *   중간연산은 파이프라인 형태로 연결할 수 있으며 스트림을 변경하지만 원본데이터에는 영향을 미치지 않는다.
     *   중간연산은 lazy(지연) 하게 동작하므로, 최종연산이 실행될 때 까지 실제 처리는 일어나지 않는다.
     */

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 10);

        // 1.filter
        System.out.println("1. filter - 짝수만 선택");
        integers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");

        // 2.map
        System.out.println("2. map - 제곱");
        integers.stream()
                .map(i -> i * i)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n---------------------------------------------");

        // 3. distinct - 중복제거
        System.out.println("3. distinct - 중복제거");
        integers.stream()
                .distinct()
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");

        // 4. sorteed - 정렬
        System.out.println("4. sorted - 기본정렬");
        Stream.of(3, 1, 4, 5, 9, 2, 6, 5)
                .sorted()
                .forEach(i -> System.out.print(i + " "));


        // 5. sorted - 커스텀 정렬
        System.out.println("5. sorted with Comparator - 내림차순 정렬");
        Stream.of(3, 1, 4, 5, 9, 2, 6, 5)
                .sorted(Comparator.reverseOrder())
                .forEach(i -> System.out.print(i + " "));

        // 6. peek
        // peek 는 그 당시 진행된 상태를 보는 메소드라고 생각하면 편하다
        // 데이터의 변경은 없기 떄문에 디버깅이나 로그를 확인하는 용도로 사용함
        System.out.println("6. peek - 동작 확인용");
        integers.stream()
                .peek(n -> System.out.print("before: " + n + ", "))
                .map(n -> n * n)
                .peek(n -> System.out.print("after: " + n + ", "))
                .limit(5)
                .forEach(n -> System.out.println("최종값: " + n));

        // 7. limit
        System.out.println("7. limit - 처음 5개 요소만");
        integers.stream()
                .limit(5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");

        // 8. skip - 처음 n 개 요소 건너뛰기
        System.out.println("8. skip - 처음 n개의 요소 건너뛰기");
        integers.stream()
                .skip(5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");


        List<Integer> integers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        // 9. takeWhile( since java9 )
        // 한 번이라도 조건이 만족되면 스트림이 즉시 종료됨
        // 따라서 정렬이 되어있을 때 효과적임
        System.out.println("9. takeWhile - 5 보다 작은 동안만 선택");
        integers2.stream()
                .takeWhile(i -> i < 5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");

        // 10. dropWhile (since java9)
        // 이 또한 조건이 만족된 이후부터 실행된다 ( 정렬된 데이터의 경우 효과적 )
        System.out.println("10. 5보다 작은동안 건너뛰기");
        integers2.stream()
                .dropWhile(i -> i < 5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n----------------------------------------------");
    }


}
