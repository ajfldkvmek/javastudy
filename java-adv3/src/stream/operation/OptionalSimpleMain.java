package stream.operation;

import java.util.Optional;

public class OptionalSimpleMain {

    /**
     *  Optional 의 이해를 돕기위한 최소한의 코드
     */

    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.of(10);
        System.out.println("optional1 = " + optional1);
        if(optional1.isPresent()) {
            // 값이 있는 지 확인할 수 있는 안전한 메소드 제공
            Integer i = optional1.get();
            System.out.println("i = " + i);
        }

        Optional<Object> optional2 = Optional.ofNullable(null);
        System.out.println("optional2 = " + optional2);
        if(optional2.isPresent()) {
            Object o = optional2.get();
            //값이 없기 때문에 실행이 되지 않음
            System.out.println("o = " + o);
        }
        //값이 없는 Optional 에서 get 호출시 NoSuchElementException 이 발생한다.

    }
}
