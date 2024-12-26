package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67, 68, 69};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        int readCount = fis.read(buffer, 0, 10);
        //offset 은 buffer 배열의 몇번때 인덱스부터 저장할 지 설정하는 부분
        //offset 과 length 를 생략할 수도 있는데 이 경우 offset은 0, length 는 byte[].length 값으로 지정된다
        System.out.println("readCount::" + readCount);
        System.out.println(Arrays.toString(buffer));
        fis.close();
    }

}
