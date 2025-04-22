package functional;

import java.util.function.Function;

public class SideEffectMain1 {

    public static int count = 0;

    public static void main(String[] args) {

        System.out.println("before count: " + count);

        // 2. 부수 효과
        Function<Integer, Integer> func = x -> {
            count++;
            return x * 2;
        };
        int result1 = func.apply(10);
        System.out.println("result1 = " + result1);
        // 함수형 프로그래밍에서는 이러한 변화를 최소화 하는 것을 지향함
        System.out.println("after count: " + count);

        
    }
}
