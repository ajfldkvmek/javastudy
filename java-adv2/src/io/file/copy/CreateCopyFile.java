package io.file.copy;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCopyFile {

    private  static final int FILE_SIZE = 200 * 1024 * 1024; //200MB

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";

        long startMs = System.currentTimeMillis();

        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(new byte[FILE_SIZE]);
        fos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("File created::" + fileName);
        System.out.println("File size::" + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("time::" + (endMs - startMs) + "ms");
    }
}
