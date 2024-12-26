package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis);
        long startMs = System.currentTimeMillis();

        int fileSize = 0;
        int size;

        while( (size = bis.read()) != -1) {
            fileSize += size;
        }
        bis.close();

        long endMs = System.currentTimeMillis();
        System.out.println("File created::" + FILE_NAME);
        System.out.println("File size::" + fileSize / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");


    }
}
