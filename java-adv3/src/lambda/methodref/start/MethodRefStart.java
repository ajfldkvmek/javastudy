package lambda.methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStart {

    public static void main(String[] args) {

//        BinaryOperator<Integer> add1 = (a, b) -> a + b;
//        BinaryOperator<Integer> add2 = (a, b) -> a + b;
        //위와같은 코드는 동일한 연산을 하는 중복된 람다식이다 위 람다를 여러곳에서 사용한다면 수정요구가 발생했을 때 수정하기 번거로움
        //따라서 메소드로 관리하는 것이 유지보수 면에서 좋다
//        BinaryOperator<Integer> add1 = (a, b) -> {
//            return add(a, b);
//        };

        //하지만 위와 같은 형태도 여러곳에서 작성하게 될 경우 번거로움이 발생한다.
        //이를 위해 람다식에서는 보통 메소드참조 형태로 결과값을 출력한다 (문법적 편의 기능)
        BinaryOperator<Integer> add1 = MethodRefStart::add;
//        Integer result = add1.apply(1, 2);
//        System.out.println("result = " + result);
        System.out.println("Result: " + add1.apply(1, 2));
    }

    static int add(int a, int b) {
        return a + b;
    }
}
