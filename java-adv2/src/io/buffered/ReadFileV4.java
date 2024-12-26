package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV4 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startMs = System.currentTimeMillis();

        byte[] buffer = fis.readAllBytes();
        fis.close();

        long endMs = System.currentTimeMillis();
        System.out.println("File created::" + FILE_NAME);
        System.out.println("File size::" + buffer.length / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");


    }
}
