package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {

        String writeString = "ABC";
        //byte 문자열을 UTF_8 방식으로 인코딩 -> String 을 byte 로 변환할때는 반드시 인코딩 방식을 지정해주어야한다!!!
        //반대의 경우도 마찬가지
        byte[] writeBytes = writeString.getBytes(UTF_8);

        System.out.println("write String::" + writeString);
        System.out.println("write bytes::" + Arrays.toString(writeBytes));

        //파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        //파일에서 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        //byte 를 String 으로 변환하기 위해서는 해당 byte 의 인코딩 방식을 해주어야함
        //byte 는 숫자데이터만 읽을 수 있기 때문
        String readString = new String(readBytes, UTF_8);

        System.out.println("read bytes::" + Arrays.toString(readBytes));
        System.out.println("read byteString::" + readString);
    }
}
