package functional;

import java.util.function.Function;

public class SideEffectMain3 {


    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> x * 2;

        int x = 10;
        Integer result = func.apply(10);

        // 이렇게 부수효과(출력)은 함수와 분리하여 실행해서 순수함수형을 유지하는 것을 권장
        System.out.println("x = " + x + ", result = " + result);

    }
}
