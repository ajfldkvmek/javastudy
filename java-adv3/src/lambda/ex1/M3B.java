package lambda.ex1;

import java.util.Arrays;

public class M3B {

    public interface Procedure {
        void run();
    }

    public static void measure(Procedure procedure) {
        long startTime = System.nanoTime();
        procedure.run();
        long endTime = System.nanoTime();
        System.out.println("startTime: " + startTime + " endTime: " + endTime);
        System.out.println("runtime: " + (endTime - startTime));
    }

    public static void main(String[] args) {


        measure(new Procedure() {
            @Override
            public void run() {
                int N = 100;
                int result = 0;
                for (int i = 0; i <= N; i++) {
                    result += i;
                }
            }
        });

        measure(new Procedure() {
            @Override
            public void run() {
                int[] a = {5, 4, 3, 2, 1};
                System.out.println("원본: " + Arrays.toString(a));
                Arrays.sort(a);
                System.out.println("정렬: " + Arrays.toString(a));
            }
        });
    }

}
