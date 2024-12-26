package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;
    public static void main(String[] args) throws IOException {
        String writeString = "ABCDE\n가나다라마";
        System.out.println("writeString\n" + writeString);

        System.out.println("==================================");
//        이렇게 인코딩방식을 생략하면
        FileWriter fw = new FileWriter(FILE_NAME);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        StringBuilder sb = new StringBuilder();
//        OS 기본 인코딩 방식으로 알아서 처리함
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        //readLine 은 읽을 값이 없을 때 null 을 반환한다. - BufferedReader 에서만 제공됨
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();

        System.out.println("read String\n" + sb);

    }
}
