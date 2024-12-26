package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67, 68, 69};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        /**
         *  readAllBytes 를 사용하면 파일 전체를 읽어온다
         *  이렇게 한번에 다 불러오게되면 불러올 파일의 크기가 클 경우 메모리를 많이 사용하게 된다.
         *  따라서 특정 길이만큼 파일을 불러오고 그 뒤 다시 그 길이만큼 불러와서 처리하는 방식으로 처리하는 경우가 좋다.
         */
        byte[] bytes = fis.readAllBytes();

        System.out.println(Arrays.toString(bytes));
        fis.close();

    }

}
