package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startMs = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int size;
        int fileSize = 0;
        // (data = fis.read(buffer, 0, buffer.length) 가 default 값으로
        // 이렇게 데이터를 넘겨주면 읽어들어온 크기를 반환함
        while( (size = fis.read(buffer)) != -1) {
            fileSize += size;
        }
        fis.close();

        long endMs = System.currentTimeMillis();
        System.out.println("File created::" + FILE_NAME);
        System.out.println("File size::" + fileSize / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");


    }
}
