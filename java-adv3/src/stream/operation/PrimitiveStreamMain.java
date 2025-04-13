package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *  자바에는 기본자료형(primitive) 특화 스트림이 있다.
 *  계산을 편리하게 하고 오토박싱/언박싱 비용을 줄인다.
 *  숫자연산에 특화된 메소드를 제공한다.
 *
 *  ex) IntStream, LongStream, DoubleStream ...
 *
 *  또한 범위를 지정할 수 있는데 ( range )
 *  range(n, m)         : n 이상 m 미만의 수
 *  rangeClosed(n, m)   : n 이상 m 이하의 수
 */

public class PrimitiveStreamMain {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        //범위 생성 메소드 -> Intstream, LongStream 에서 제공
        IntStream range1 = IntStream.range(1, 5); // (1, 2, 3, 4)
        IntStream range2 = IntStream.rangeClosed(1, 5); //(1, 2, 3, 4, 5)

        // 1. 통계 관련 메소드 - sum, average, max, min, count
        int range3 = IntStream.rangeClosed(1, 5).sum();
        System.out.println("range3 = " + range3);

        // 2. 평균 - 값이 없을 수 있기 때문에 Optional 이 사용됨
        OptionalDouble average = IntStream.rangeClosed(1, 5).average();
        System.out.println("average = " + average.getAsDouble());


        // 3. summaryStatistics(): 모든 통계정보
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 5).summaryStatistics();
        System.out.println("intSummaryStatistics.getMax() = " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getMin() = " + intSummaryStatistics.getMin());
        System.out.println("intSummaryStatistics.getSum() = " + intSummaryStatistics.getSum());
        System.out.println("intSummaryStatistics.getAverage() = " + intSummaryStatistics.getAverage());
        System.out.println("intSummaryStatistics.getCount() = " + intSummaryStatistics.getCount());
        System.out.println("intSummaryStatistics.toString() = " + intSummaryStatistics.toString());

        // 타입 변환 메소드
        // IntStream -> LongStream
        LongStream longStream = IntStream.rangeClosed(1, 5).asLongStream();
        // IntStream -< DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();
        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.rangeClosed(1, 5).boxed();

        // 기본형 특화 매핑
        // int -> long
        LongStream longStream1 = IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);
        //int -> double
        DoubleStream doubleStream1 = IntStream.range(1, 5)
                .mapToDouble(i -> i * 1.3);

        //int -> obj
        Stream<Integer> integerStream = IntStream.range(1, 5)
                .mapToObj(i -> i * 10);

        // 4. 객체 스트림을 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);
        //이런 객체형 스트림은 계산을 못함
        //따라서 단순 계산을 하기 위해서
        IntStream intStream1 = integerStream1.mapToInt(i -> i);
        int sum = intStream1.sum();
        System.out.println("sum = " + sum);
        
        // 객체 스트림에서 기본형 특화 스트림 활용
        // 보통 이런식으로 바로 사용함
        int sum1 = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println("sum1 = " + sum1);

    }

}
