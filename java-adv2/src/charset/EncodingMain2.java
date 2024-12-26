package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {

        System.out.println("=== 영문 ASCII 인코딩 ===");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1);
        test("A", US_ASCII, EUC_KR);
        test("A", US_ASCII, MS_949);
        test("A", US_ASCII, UTF_8);
        test("A", US_ASCII, UTF_16BE); //이놈만 인코딩 방식이 2byte 이기 때문에 안되는 것을 보여줌

        System.out.println("=== 한글 인코딩 기본 ===");
        test("가", US_ASCII, US_ASCII); //기본적으로 한글은 2byte 이상이기 때문에 1byte 인 ASCII 인코딩방식으로는 인코딩부터 되지 않음
        test("가", ISO_8859_1, ISO_8859_1); //이놈도 1byte 라 한글 인코딩 안됨
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16BE, UTF_16BE);

        System.out.println("=== 한글 인코딩 복잡한 문자 ===");
        test("쀍", EUC_KR, EUC_KR); // 얘는 기본 한글 조합만 가능
        test("쀍", MS_949, EUC_KR); // 얘는 EUC_KR 의 확장이라 복잡한 한글 가능
        test("쀍", UTF_8, UTF_8); // 얘는 모든 문자표현이 가능
        test("쀍", UTF_16BE, UTF_16BE);

        System.out.println("=== 한글 인코딩, 디코딩 방식이 다를 경우 ===");
        test("가", EUC_KR, MS_949);
        test("쀍", MS_949, EUC_KR); // 인코딩은 가능하지만 디코딩은 안됨
        test("가", EUC_KR, UTF_8); // EUC_KR 과 UTF-8 은 호환되지 않음
        test("가", MS_949, UTF_8); // 대부분 윈도우에서 마주하는 문제로 MS_949와 UTF-8 는 호환 안됨
        test("가", UTF_8, MS_949); // 대부분 윈도우에서 마주하는 문제로 MS_949와 UTF-8 는 호환 안됨


        System.out.println("=== 영문 인코딩, 디코딩 방식이 다를 경우 ===");
        test("A", EUC_KR, UTF_8);
        test("A", MS_949, UTF_8);
        test("A", UTF_8, EUC_KR);
        test("A", UTF_8, MS_949);
        test("A", UTF_8, UTF_16BE); // 이놈은 안됨
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoding = text.getBytes(encodingCharset);
        String decoding = new String(encoding, decodingCharset);

        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n"
                        , text, encodingCharset, Arrays.toString(encoding), encoding.length
                        , decodingCharset, decoding);
    }


}
