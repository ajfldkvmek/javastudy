package stream.optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        //값이 존재하면 Consumer 실행 없으면 아무것도 하지 않음
        System.out.println("======= 1. ifPresent() =======");
        optValue.ifPresent(v -> System.out.println("optValue 값: " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값: " + v));

        //값이 있으며 Consumer 실행, 없으면 Runnable 실행
        System.out.println("======= 2. ifPresentOfElse() =======");
        optValue.ifPresentOrElse(
                v -> System.out.println("optValue 값: " + v),
                () -> System.out.println("optValue 는 비어있음")
        );
        optEmpty.ifPresentOrElse(
                v -> System.out.println("optEmpty 값: " + v),
                () -> System.out.println("optEmpty 는 비어있음")
        );

        // 값이 있으면 Function 적용 후 Optional 반환, 없으면 Optional.empty()
        System.out.println("======= 3. map() =======");
        Optional<Integer> i = optValue.map(String::length);
        System.out.println("optValue.map(String::length) = " + i);
        Optional<Integer> iEmpty = optEmpty.map(String::length);
        System.out.println("optEmpty.map(String::length) = " + iEmpty);

        // flatMap - 이미 Optional 을 반환하는 경우 중첩제거
        System.out.println("======= 4. flatMap() =======");
        Optional<Optional<String>> nested = optValue.map(s -> Optional.of(s));
        System.out.println("nested = " + nested);

        Optional<String> nestedFlat = optValue.flatMap(s -> Optional.of(s));
        System.out.println("nestedFlat = " + nestedFlat);

        // 값이 있고 + 조건을 만족하면 그 값을 그대로, 불만족 시 Optional.empty();
        System.out.println("======= 5. filter() =======");
        Optional<String> filterStartH = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filterStartX = optValue.filter(s -> s.startsWith("X"));
        Optional<String> filterNull = optEmpty.filter(s -> s == null);

        System.out.println("filterStartH = " + filterStartH);
        System.out.println("filterStartX = " + filterStartX);
        System.out.println("filterNull = " + filterNull);


        // 값이 있으면 단일 요소 스트림 없으면 빈 스트림
        System.out.println("======= 6. stream() =======");
        optValue.stream()
                .forEach(s -> System.out.println("optValue.stream() = " + s));
        //값이 없으므로 실행안됨
        optEmpty.stream().forEach(s -> System.out.println("optEmpty.stream() = " + s));
    }

}
