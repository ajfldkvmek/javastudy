package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV1 {

    public static void main(String[] args) throws IOException {

        long startMs = System.currentTimeMillis();

        //한번에 모든 데이터를 불러와 저장하기
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

        byte[] bytes = fis.readAllBytes();
        fos.write(bytes);

        fis.close();
        fos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("time::" + (endMs - startMs) + "ms");


    }
}
