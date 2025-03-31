package lambda.start;

import lambda.Procedure;

import java.util.Random;

public class Ex1MainV2 {

    public static void hello(Procedure proc) {
        long startNs = System.nanoTime();

        //here
        proc.run();

        long endNs = System.nanoTime();

        System.out.println("실행시간: " + (endNs - startNs) + "ns");
    }


    public static void main(String[] args) {
        //익명 클래스로 생성하기
        Procedure dice = new Procedure() {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위: " + randomValue);
            }
        };

        Procedure sum = new Procedure() {
            @Override
            public void run() {
                for (int i = 0; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        };

        hello(dice);
        hello(sum);

    }
}
