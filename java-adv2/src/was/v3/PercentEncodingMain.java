package was.v3;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 *  HTML 의 헤더는 기본적으로 ASCII 인코딩을 기본적으로 사용하기때문에 한글이나 특수문자 같은 건 제대로 못받음
 *  따라서 인코딩-디코딩 과정이 반드시 필요함 (바디에서는 다른 인코딩방식 사용 가능)
 */
public class PercentEncodingMain {

    public static void main(String[] args) {
        String encode = URLEncoder.encode("가", UTF_8);
        System.out.println("encode::" + encode);

        String decode = URLDecoder.decode(encode, UTF_8);
        System.out.println("decode::" + decode);
    }
}
