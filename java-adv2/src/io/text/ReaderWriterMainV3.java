package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABCDE";
        System.out.println("writeString::" + writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
//        FileWriter fw = new FileWriter(FILE_NAME); //이렇게 인코딩방식을 생략하면
        fw.write(writeString);
        fw.close();

        //파일에서 읽기
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
//        FileReader fr = new FileReader(FILE_NAME); //OS 기본 인코딩 방식으로 알아서 처리함

        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }

        fr.close();

        String str = sb.toString();
        System.out.println("read String::" + str);

    }
}
