package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain2 {

    public static void main(String[] args) {

        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("변수로 전달");

        calcuate(add);
        calcuate(sub);

    }
    static void calcuate(MyFunction function){

        int a = 1;
        int b = 2;

        System.out.println("계산 시작");
        int res = function.apply(a, b);
        System.out.println("계산 결과: " + res);
    }
}
