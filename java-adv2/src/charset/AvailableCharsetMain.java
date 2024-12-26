package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetMain {

    public static void main(String[] args) {

        SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (String s : charsets.keySet()) {
            System.out.println("charsetName::" + s);
        }

        System.out.println("======================================");

        //특정 문자열의 집합을 찾을 때 Charset.forName("name") 을 사용하면 된다.
        //찾으려는 문자열 집합을 파라메터로 날리면 된다
        //  ex. MS949, UTF-8, EUC-KR 등
        Charset charset1 = Charset.forName("MS949");
        System.out.println("charset1::" + charset1);

        //별칭 조회
        Set<String> alias = charset1.aliases();
        for (String s : alias) {
            System.out.println("alias::" + alias);
        }

        //utf-8 문자 조회
        Charset charset2 = Charset.forName("UTF-8");
        System.out.println("charset2::" + charset2);


        // 이렇게 상수로도 조회가 가능하다 몇가지가 상수로 선언되어 있으니 참고 바람
        Charset utf8 = StandardCharsets.UTF_8;

        //시스템의 기본 Charset 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset::" + defaultCharset);



    }


}
