package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {

    public static void main(String[] args) {


//        Stream.of(1, 2, 3)
//                        .collect(Collectors.maxBy((a, b) -> a.compareTo(b)));
        // 이런 min max 는 다운스트림 컬랙터에서 유용하게 사용할 수 있음 그게 아니라면 아래 처럼 .max() 를 사용하여 간편하게 사용하면 된다!
        Integer max1 = Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(Integer::compareTo)).get();
        System.out.println("max1 = " + max1);


        Integer max2 = Stream.of(1, 2, 3)
                .max(Integer::compareTo).get();
        System.out.println("max2 = " + max2);

        //기본형 특화 스트림의 경우
        int asInt = IntStream.of(1, 2, 3)
                .max().getAsInt(); //값을 출력하기 위해서는 getAsInt() 반드시 해줘야함
        System.out.println("max4 = " + asInt);



    }
}
