package stream.start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {

    public static void main(String[] args) {

        List<String> names = List.of("Apple", "Banana", "Orange", "Tomato", "bananana");

        //B로 시작하는 이름만 필터후 대문자로 바꾸기
        Stream<String> stream = names.stream();
        List<String> result1 = stream.filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .toList();
        //만약 대소문자 관계없이 접두사를 비교하려면???
        //아래와 같이 toUpperCase 또는 toLowerCase 로 변경하면된다.
        //자바에서 제공하는 stream 은 재사용할 수 없기 떄문에 다시 사용하려면 새로 선언해야함
        Stream<String> stream2 = names.stream();
        List<String> result2 = stream2.filter(name -> name.toUpperCase().startsWith("B"))
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println("외부 반복 출력");
        System.out.println("=============================================");
        for (String s : result1) {
            System.out.println("s = " + s);
        }
        System.out.println("---------------------------------------------");
        for (String s : result2) {
            System.out.println("s = " + s);
        }
        System.out.println("---------------------------------------------");

        System.out.println("=============================================");

        System.out.println("내부 반복 출력(forEach)");
        System.out.println("---------------------------------------------");

        //스트림 여러번 쓰려면 이렇게 선언 없이 실행하면된다ㄴ
        names.stream()
                .filter(n -> n.startsWith("B"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

        System.out.println("내부 반복 출력(forEach) + 메소드참조");
        System.out.println("---------------------------------------------");
        names.stream()
                .filter(n -> n.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
