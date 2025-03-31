package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {

    public static void main(String[] args) {
        //타입 생략전
        MyFunction myFunction = (int a, int b) -> a + b;
        System.out.println(myFunction.apply(3, 4));

        //타입생략(타입추론)
        MyFunction myFunction2 = (a, b) -> a + b;
        System.out.println(myFunction2.apply(3, 4));
    }

}
