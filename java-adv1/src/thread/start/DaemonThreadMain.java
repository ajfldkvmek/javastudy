package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        /**
         *  자바는 스레드가 종료되면 데몬스레드의 존재 여부에 관계없이 무조건 종료된다.
         *  
         *  데몬스레드는 반드시 스레드 생성시에 지정하여야하고 수정하지마라
         *
         *  또한 run() 에서는 예외처리를 할 때 throw 를 하지 못하기 때문에 반드시
         *  try-catch를 사용하여 예외를 잡아야한다.
         */
        System.out.println(Thread.currentThread().getName() + ": main() start");

        DamonThread damonThread = new DamonThread();
        damonThread.setDaemon(false); //데몬스레드 여부
        damonThread.start();

        System.out.println(Thread.currentThread().getName() + ": run() end");
    }

    static class DamonThread extends Thread {
        @Override
        public void run(){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run()");
        }
    }
}
