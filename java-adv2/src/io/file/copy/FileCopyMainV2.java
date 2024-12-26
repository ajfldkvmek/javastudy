package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2 {

    public static void main(String[] args) throws IOException {

        long startMs = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

//        byte[] bytes = fis.readAllBytes();
//        fos.write(bytes);
        fis.transferTo(fos); //위에있는건 이거처럼 표현가능함(성능최적화도 된) - java9 부터 지원

        fis.close();
        fos.close();

        long endMs = System.currentTimeMillis();

        System.out.println("time::" + (endMs - startMs) + "ms");


    }
}
