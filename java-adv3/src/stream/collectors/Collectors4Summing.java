package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {

    public static void main(String[] args) {

        //이 친구도 다운스트림 컬랙터에서 유용하게 사용
        Long count1 = Stream.of(1, 2, 3)
                .collect(Collectors.counting());
        System.out.println("count1 = " + count1);
//        아래와 같이 간단하게 표현도 가능
//        Long count2 = Stream.of(1, 2, 3).count();
//        System.out.println("count2 = " + count2);

        Double average = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(x -> x));
        System.out.println("average = " + average);

        //기본형 특화 스트림으로 변환
        double asDouble = Stream.of(1, 2, 3)
                .mapToInt(x -> x)
                .average().getAsDouble();
        System.out.println("asDouble = " + asDouble);

        //기본형 특화스트림
        double asDouble2 = IntStream.of(1, 2, 3)
                .average().getAsDouble();
        System.out.println("asDouble2 = " + asDouble2);

        //통계
        IntSummaryStatistics stats = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("stats.getMax() = " + stats.getMax());
        System.out.println("stats.getMin() = " + stats.getMin());
        System.out.println("stats.getSum() = " + stats.getSum());
        System.out.println("stats.getAverage() = " + stats.getAverage());
        System.out.println("stats.getCount() = " + stats.getCount());

    }

}
