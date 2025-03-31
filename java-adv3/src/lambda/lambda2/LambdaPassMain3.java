package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain3 {

    public static void main(String[] args) {

        MyFunction add = getOperation("add");
        System.out.println("add.apply(3, 4) = " + add.apply(3, 4));

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply(3, 4) = " + sub.apply(3, 4));

        MyFunction mul = getOperation("mul");
        System.out.println("mul.apply(3, 4) = " + mul.apply(3, 4));

    }

    static MyFunction getOperation(String operation) {
        switch (operation) {
            case "add":
                return (int a, int b) -> a + b;
            case "sub":
                return (int a, int b) -> a - b;
            default:
                return (a, b) -> 0;
        }

    }


}
