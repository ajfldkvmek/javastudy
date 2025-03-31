package lambda.start;

import lambda.Procedure;

import java.util.Random;

public class Ex1Main {
//
//    public static void helloDice() {
//        long startNs = System.nanoTime();
//
//        int randomValue = new Random().nextInt(6) + 1;
//        System.out.println("주사위: " + randomValue);
//        long endNs = System.nanoTime();
//
//        System.out.println("실행시간: " + (endNs - startNs) + "ns");
//
//    }
//
//
//    public static void helloSum() {
//        long startNs = System.nanoTime();
//
//        for (int i = 0; i <= 3; i++) {
//            System.out.println("i = " + i);
//        }
//
//        long endNs = System.nanoTime();
//
//        System.out.println("실행시간: " + (endNs - startNs) + "ns");
//
//    }

    public static void hello(Procedure proc) {
        long startNs = System.nanoTime();

        //here
        proc.run();

        long endNs = System.nanoTime();

        System.out.println("실행시간: " + (endNs - startNs) + "ns");
    }


    public static void main(String[] args) {
//        helloDice();
//        helloSum();
        Procedure Dice = new Dice();
        Procedure Sum = new Sum();

        hello(Dice);
        hello(Sum);

    }

    static class Dice implements Procedure {
        @Override
        public void run() {
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위: " + randomValue);
        }
    }
    static class Sum implements Procedure {
        @Override
        public void run() {
            for (int i = 0; i <= 3; i++) {
            System.out.println("i = " + i);
        }
        }
    }


}
