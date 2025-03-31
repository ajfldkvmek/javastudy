package lambda.lambda1;

import lambda.Procedure;

public class LambdaSimple2 {

    public static void main(String[] args) {

        Procedure proc = () -> {
            System.out.println("Hello Lambda");
        };
        proc.run();

        Procedure proc2 = () -> System.out.println("Hello Lambda2");
        proc2.run();
    }

}
