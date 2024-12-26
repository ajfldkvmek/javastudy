package thread.control.intrrupt.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV3 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner input = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요(q: 종료)");
            String in = input.nextLine();
            if(in.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(in);
        }
    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //여러 쓰레드가 같이 접근하는 경우에는 Concurrent 를 사용하는 것이 좋다

        @Override
        public void run() {
            while(!Thread.interrupted()){
                if(jobQueue.isEmpty()) {
                    //쓰레드의 작업량이 많다면 이렇게 yield 로 잠깐 쉬어가기
                    Thread.yield();
                }
                try {
                    String job = jobQueue.poll();
                    log("출력시작: " + job + ", 대기문서: " + jobQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log("인터럽트");
                    break;
                }
                log("출력완료");
            }
            log("프린터 종료");
        }
        public void addJob(String input){
            jobQueue.offer(input);
        }
    }
}
