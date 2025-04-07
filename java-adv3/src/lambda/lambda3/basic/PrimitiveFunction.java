package lambda.lambda3.basic;


import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

/**
 * 기본형 지원 함수형 인터페이스가 존재하는 이유는
 * 1. 오토박싱/언박싱 으로 인한 성능비용을 줄이기 위해
 * 2. 자바 제네릭의 한계를 극복하기 위해(자바 제네릭은 primitive 타입을 직접 다룰 수 없음)
 * IntFunction 등
 */
public class PrimitiveFunction {

    public static void main(String[] args) {

        //IntFunction, DoubleFunction, DoubleFunction...
        IntFunction<String> function1 = x -> "숫자: " + x;
        System.out.println("function1.apply(1) = " + function1.apply(1));

        //기본형 반환
//        ToIntFunction<String> toIntFunction = s -> s.length();
        ToIntFunction<String> toIntFunction = String::length;
        System.out.println("toIntFunction = " + toIntFunction);

        //기본형 매개변수 + 기본형 반환
        IntToLongFunction intToLongFunction = x -> x * 2L;
        System.out.println("intToLongFunction = " + intToLongFunction.applyAsLong(3));

        //IntUnary
        IntUnaryOperator intUnaryOperator = x -> x * 2;
        System.out.println("intUnaryOperator = " + intUnaryOperator.applyAsInt(3));

        //기타, IntConsumer, IntPredicate...
    }

}
