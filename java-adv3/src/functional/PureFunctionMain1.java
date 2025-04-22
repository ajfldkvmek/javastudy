package functional;

import java.util.function.Function;

public class PureFunctionMain1 {

    public static void main(String[] args) {

        // 1. 순수 함수
        Function<Integer, Integer> func = x -> x * 2;
        int result1 = func.apply(10);
        System.out.println("result1 = " + result1);


    }
}
