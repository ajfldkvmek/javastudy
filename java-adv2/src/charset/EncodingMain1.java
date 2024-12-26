package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("=== ASCII 영문 처리 ===");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE); //이렇게 문자 인코딩 방식이 2byte로 다른 경우 호환이 안됨

        System.out.println("=== 한글 지원 인코딩 ===");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", UTF_8); // utf8 의경우 한글을 3byte 로 사용하기 떄문에 호환이 안됨
        encoding("가", UTF_16BE);

        String str = "A";
        byte[] bytes = str.getBytes(); //getBytes("encoding") 에서 encoding 방식을 지정하지 않으면 시스템 기본 문자인코딩 방식으로 인식함
        System.out.println("bytes>>>"+ Arrays.toString(bytes));

    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
