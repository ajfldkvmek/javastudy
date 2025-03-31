package lambda.start;

public class Ex0Main {

    public static void hello(String str) {
        System.out.println("program start");
        System.out.println("Hello " + str);
        System.out.println("program end");
    }
//
//    public static void helloJava() {
//        System.out.println("program start");
//        System.out.println("Hello Java");
//        System.out.println("program end");
//    }
//
//
//    public static void helloSpring() {
//        System.out.println("program start");
//        System.out.println("Hello Spring");
//        System.out.println("program end");
//    }
//

    public static void main(String[] args) {
        hello("java");
        hello("hello");
    }
}
