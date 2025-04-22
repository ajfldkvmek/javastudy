package functional;

import java.util.function.Function;

public class SideEffectMain2 {


    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> {
            int result = x * 2;
            // 2. 부수 효과 -> 콘솔창에 출력되는 것 조차 부수효과로 취급한다.
            System.out.println("x = " + x + ", result = " + (x * 2));
            return result;
        };
        func.apply(10);
        func.apply(10);
        func.apply(10);
        func.apply(10);
        func.apply(10);

    }
}
