package io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEtcMain {

    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);
//        PrintStream 은 우리가 쓰는 아래있는 이 놈이다
//        System.out.println();
//        이 놈을 이용하면 마치 콘솔에 출력하는 것 처럼 다른 파일이나 스트림에 문자열을 출력할 수 있다.
        printStream.println("qwer");
        printStream.println(10);
        printStream.println(true);

        printStream.close();
    }


}
