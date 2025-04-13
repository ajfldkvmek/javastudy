package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {

    public static void main(String[] args) {
        System.out.println("컬렉션으로부터 생성---------------");
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        System.out.println("배열로부터 생성-----------------");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::println);

        System.out.println("stream.of--------------------");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.forEach(System.out::println);

        System.out.println("무한 스트림 생성");
        //iterator: 초기값과 다음 값을 만드는 함수를 지정
        //mac 에서 실행종료: cmd+F2
        Stream<Integer> infinieStream = Stream.iterate(0, n -> n + 2);
//        infinieStream.forEach(System.out::println);
        //아래처럼 limit 를 걸어 몇개를 스트림실행할 지 제한할 수 있음
        infinieStream.limit(3).forEach(System.out::println);

        //generate 또한 iterator 처럼 무한히 스트림을 실행한다.
        //따라서 둘 다 제한을 걸어줘야함
        System.out.println("무한스트림 - generate()");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
