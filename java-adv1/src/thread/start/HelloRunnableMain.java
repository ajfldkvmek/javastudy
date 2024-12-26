package thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {

        /**
         *  Thread를 상속하는 것 보다
         *  Runnable을 구현하는 것이 더 좋다
         */
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");

    }


}
