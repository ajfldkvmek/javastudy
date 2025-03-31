package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple1 {

    public static void main(String[] args) {

        MyFunction myFunction1 = (int a, int b) -> {
            return a + b;
        };

        System.out.println("function1 = " + myFunction1.apply(1, 2));

        //단일 표현식이면 중괄호, return 생략가능
        MyFunction myFunction2 = (int a, int b) -> a + b;
        System.out.println("function2 = " + myFunction2.apply(1, 2));

        //단일 표현식이 아닐경우 중괄호 return 필수
        MyFunction myFunction3 = (int a, int b) -> {
            System.out.println("람다!");
            return a + b;
        };
        System.out.println("function3 = " + myFunction3.apply(1, 2));


    }
}
