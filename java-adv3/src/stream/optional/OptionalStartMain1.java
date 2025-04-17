package stream.optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "Kim");
        map.put(2L, "Seo");
    }

    public static void main(String[] args) {

        findAndPrint(1L);
        findAndPrint(3L);
    }

    //이름 있으면 대문자로 출력 없으면 unknown 출력
    //인데 이렇게 매번 null 체크를 하게되면 코드가 지저분해짐
    static void findAndPrint(Long id) {
        String name = findNameById(id);
        if (name != null) {
            System.out.println("name = " + name.toUpperCase());
        } else {
            System.out.println("name = unknown");
        }
    }

    static String findNameById(Long id) {
        return map.get(id);
    }

}
