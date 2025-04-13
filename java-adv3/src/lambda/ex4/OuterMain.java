package lambda.ex4;

public class OuterMain {

    public String message = "외부 클래스";

    public void execute() {
        //익명클래스 예시
        Runnable anonymous = new Runnable() {
            private String message = "익명 클래스";

            public void run() {
                // 익명 클래스에서의 this 는 익명클래스의 인스턴스를 가리킴
                System.out.println("[익명 클래스] this: " + this);
                System.out.println("[익명 클래스] this.class: " + this.getClass());
                System.out.println("[익명 클래스] this.message: " + this.message);
            }
        };

        // 2. 람다 예시
        Runnable lambda = () -> {
            //람다에서의 this는 람다가 선언된 클래스의 인스턴스 즉, 외부클래스를 가리킴
            System.out.println("[람다] this: " + this);
            System.out.println("[람다] this.class: " + this.getClass());
            System.out.println("[람다] this.message: " + this.message);
        };

        anonymous.run();
        System.out.println("----------------------------------------------");
        lambda.run();
    }

    public static void main(String[] args) {
        OuterMain outerMain = new OuterMain();
        System.out.println("[외부 클래스] : " + outerMain);
        System.out.println("----------------------------------------------");
        outerMain.execute();
    }
}
