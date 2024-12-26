package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString::" + writeString);

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        //OutputStreamWriter 는 문자열을 byte 로 전처리 해줄필요없이 문자열만 전달하면 알아서 처리해준다
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
        osw.write(writeString);
        osw.close();

        //읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuilder sb = new StringBuilder();
        int ch;
        //isr 의 read 는 char 를 반환함
        //참고로 자바의 char 형은 양수만 다룰 수 있다.
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();

        System.out.println("read String::" + sb);

    }
}
