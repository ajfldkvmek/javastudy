package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        long startMs = System.currentTimeMillis();

        byte[] buffered = new byte[BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i++) {
            buffered[bufferIndex++] = 1;
//            bufferIndex++;
            //버퍼가 가득차면 쓰고 버퍼를 비움
            if (bufferIndex == BUFFER_SIZE) {
                fos.write(buffered);
                bufferIndex = 0;
            }
        }
        //만약 버퍼의 사이즈를 다 채우지 못하고 끝날 경우 남은 크기만큼 더 write
        if (bufferIndex > 0) {
            fos.write(buffered, 0 , bufferIndex);
        }
        fos.close();
        long endMs = System.currentTimeMillis();
        System.out.println("File created::" + FILE_NAME);
        System.out.println("File size::" + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");
    }
}
