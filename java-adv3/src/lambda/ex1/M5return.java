package lambda.ex1;

import lambda.MyFunction;

public class M5return {

    public static MyFunction getOperator(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a,b) -> 0;
        }
    }

    public static void main(String[] args) {

        MyFunction func1 = M5return.getOperator("add");
        MyFunction func2 = M5return.getOperator("sub");

        System.out.println("func1.apply(1,2) = " + func1.apply(1, 2));
        System.out.println("func2.apply(1, 2) = " + func2.apply(1, 2));
    }

}
