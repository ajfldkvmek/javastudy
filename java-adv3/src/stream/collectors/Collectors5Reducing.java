package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors5Reducing {

    public static void main(String[] args) {
        List<String> names = List.of("a", "b", "c", "d");

        //컬랙션의 리듀싱은 주로 다운스트림에 활용
        //모든 요소 붙이기
        String joined1 = names.stream()
                .collect(Collectors.reducing(
                        (s1, s2) -> s1 + " " + s2
                )).get();
        System.out.println("joined1  = " + joined1 );

        String joined2 = names.stream()
                .reduce((s1, s2) -> s1 + " " + s2).get();
        System.out.println("joined2 = " + joined2);

        //문자열 전용기능
        String joined3 = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("joined3 = " + joined3);

        // BUT!!!!!!!!!!!!!!! 이걸 굳이 쓰지는 않는데...
        String join = String.join(", ", names);
        System.out.println("join = " + join); //java8 부터
        // 이렇게 String 에서 자체적으로 제공됨


    }

}
