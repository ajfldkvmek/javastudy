package lambda.lambda1;

public class LambdaSimple4 {

    public static void main(String[] args) {
        MyCall myCall1 = (int value) -> value * 2;
        MyCall myCall2 = (value) -> value * 2;
        //매개변수가 1개일 경우에만 생략가능
        MyCall myCall3 = value -> value * 2;

        System.out.println("myCall3 = " + myCall3.call(10));
    }

    interface MyCall {
        int call(int value);
    }
}
