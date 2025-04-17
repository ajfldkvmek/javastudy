package stream.optional;

import java.util.Optional;

public class OptionCreationMain {

    public static void main(String[] args) {
        // 1. of(): 값이 null 이 아님이 확실할 때 사용
        String notNullValue = "Hello Optional!";
        Optional<String> optional1 = Optional.of(notNullValue);
        System.out.println("optional1 = " + optional1);

        // 2. ofNullable() null 일수도 아닐수도 있을 때
        Optional<String> optional2 = Optional.ofNullable("Hello");
        Optional<String> optional3 = Optional.ofNullable(null);
        System.out.println("optional2 = " + optional2);
        System.out.println("optional3 = " + optional3); //Optional 은 내부에 기본적을 EMPTY 객체를 가지고 있어 null 이 확인될 경우 empty 가 나옴

        // 3. empty() 비어있는 Optional 을 명시적으로 생성
        Optional<String> optional4 = Optional.empty();
        System.out.println("optional4 = " + optional4);




    }

}
