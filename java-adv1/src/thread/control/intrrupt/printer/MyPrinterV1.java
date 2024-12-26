package thread.control.intrrupt.printer;

import util.MyLogger;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.*;
import static util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner input = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요(q: 종료)");
            String in = input.nextLine();
            if(in.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(in);
        }
    }
    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //여러 쓰레드가 같이 접근하는 경우에는 Concurrent 를 사용하는 것이 좋다

        @Override
        public void run() {
            while(work){
                if(jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                log("출력시작: " + job + ", 대기문서: " + jobQueue);
                sleep(3000);
                log("출력완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input){
            jobQueue.offer(input);
        }
    }
}
