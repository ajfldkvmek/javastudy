package lambda.start;

import lambda.Procedure;

import java.util.Random;

public class Ex1MainV4 {

    public static void hello(Procedure proc) {

        long startNs = System.nanoTime();
        proc.run();
        long endNs = System.nanoTime();
        System.out.println("실행시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        //익명 클래스로 생성하기
        //참조값 바로 넘기기
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위: " + randomValue);
        });

        hello(() -> {
            for (int i = 0; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        });

    }
}
