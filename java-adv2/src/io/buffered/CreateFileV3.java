package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {

        /**
         *  BufferedOutputStream 는 단독으로 쓸 수 없고
         *  반드시 대상 outputstream 이 필요하다.
         *  만약 버퍼에 데이터를 다 채우지 않아도 데이터를 보내고 싶다면 flush() 를 사용하면 된다.
         *  *** 만약 버퍼에 데이터가 남아있는 상태로 close 를 하게되면 이전에 flush 를 한 번 실행한 뒤 close 가 실행된다
         */
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE); //내부에 buffer 기능을 가지고 있고, 파라메터로 버퍼크기 설정 가능
        long startMs = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close();
        long endMs = System.currentTimeMillis();
        System.out.println("File created::" + FILE_NAME);
        System.out.println("File size::" + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");
    }
}
