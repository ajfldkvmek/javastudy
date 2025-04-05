package lambda.ex1;

public class M1Before {

    public static void greet(String message) {
        System.out.println("===== start =====");
        System.out.println(message);
        System.out.println("===== end =====");
    }


    public static void main(String[] args) {
        greet("HIHI");
        greet("ㅎㅇㅎㅇ");
        greet("HIㅎㅇ");
    }
}
