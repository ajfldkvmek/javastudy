package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            public void run() {
                System.out.println("Hello Lambda");
            }
        };
        System.out.println("class.getClass() = " + procedure.getClass());
        System.out.println("class.instance = " + procedure);

        Procedure procedure2 = () -> {
            System.out.println("Hello Lambda");
        };
        System.out.println("lambda.getClass() = " + procedure2.getClass());
        System.out.println("lambda.instance = " + procedure2);

    }
}
