package stream.optional;

import java.util.Optional;

public class OptionalRetrievalMain {

    public static void main(String[] args) {

        //예제: 문자열 "hello" 가 있는 Optional 과 비어있는 Optional
        Optional<String> optional1 = Optional.of("hello");
        Optional<String> optional2 = Optional.empty();

        // isPresent(): 값이 있으면 true 반환
        // isEmpty() 는 Java11 부터 사용
        System.out.println("======= 1. isPresent() / isEmpty() ========");
        System.out.println("optional1.isPresent() = " + optional1.isPresent());
        System.out.println("optional2.isPresent() = " + optional2.isPresent());
        System.out.println("optional2.isEmpty() = " + optional2.isEmpty());

        // get(): 직접 내부값을 꺼냄, 값 없으면 NoSearchElementException 출력
        // 단순 get() 메소드는 Optional 을 사용할 때 100% 보장되는 것이 아니면 사용하지 않는 것을 권장
        System.out.println("======= 2. get() =========");
        System.out.println("optional1.get() = " + optional1.get());
//        System.out.println("optional2.get() = " + optional2.get()); //NoSearchElementException

        // 값이 있으면 그 값을, 없으면 지정된 값을 사용
        System.out.println("======= 3. orElse() =========");
        String defaultValue1 = optional1.orElse("default");
        String defaultValue2 = optional2.orElse("default");
        System.out.println("defaultValue1 = " + defaultValue1);
        System.out.println("defaultValue2 = " + defaultValue2);

        // 값이 없을 때만 Lambda(Supplier)가 실행되거 기본값 생성
        System.out.println("======= 4. orElseGet() =========");
        String orElseGet1 = optional1.orElseGet(() -> {
            System.out.println("람다 호출 optional1");
            return "New Value";
        });
        System.out.println("orElseGet1 = " + orElseGet1);

        String orElseGet2 = optional2.orElseGet(() -> {
            System.out.println("람다 호출 optional2");
            return "Empty Value";
        });
        System.out.println("orElseGet2 = " + orElseGet2);


        // 값이 있으면 반환 없으면 예외 발생 ( 예외를 발생시켜야할 경우가 필요할 때도 있음)
        System.out.println("======= 5. orElseThrow() =========");
        String orElseThrow1 = optional1.orElseThrow(() -> new RuntimeException("값이 없습니다!"));
        System.out.println("orElseThrow1 = " + orElseThrow1);
        try {
            String orElseThrow2 = optional2.orElseThrow(() -> new RuntimeException("값이 없습니다!"));
            System.out.println("orElseThrow2 = " + orElseThrow2); //실행안됨
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 값이 있으면 그 값을 Optional 에 답아서 반환 없으면 default 값을 Optional 을 반환 - 잘 사용하지는 않음
        System.out.println("======= 6. or() =========");
        Optional<String> or1 = optional1.or(() -> Optional.of("FallBack"));
        Optional<String> or2 = optional2.or(() -> Optional.of("FallBack"));
        System.out.println("or1 = " + or1);
        System.out.println("or2 = " + or2);

    }

}
