package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        /**
         *  run() 메소드가 아니라 반드시 start() 메소드를 실행해야함
         *  start() 메소드를 통해 run() 이 실행되는 것
         *  
         *  ******************************************************
         *  
         *  main 스레드가 run을 호출하는 것이 아니라
         *  main 스레드는 단순히
         *  thread-0 에게 run을 실행하라고 명령하는 것이 끝
         */
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

}
