package lambda.lambda3.operator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 *  입력과 반환이 동일한 경우 Operator 를 사용한다
 */
public class OperatorMain {

    public static void main(String[] args) {

        //UnaryOperator - 매개변수를 하나만 받음
        UnaryOperator<Integer> square1 = x -> x * x;
        System.out.println("square1.apply(5) = " + square1.apply(5));

        //BinaryOperator - 매개변수 두 개 받음
        BinaryOperator<Integer> bi1 = (x, y) -> x * y;
        System.out.println("bi1.apply(1, 2) = " + bi1.apply(1, 2));


    }
}
