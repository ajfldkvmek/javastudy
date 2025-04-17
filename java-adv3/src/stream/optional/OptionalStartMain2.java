package stream.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

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
        Optional<String> optName = findNameById(id);
        String name = optName.orElse("unknown");
        System.out.println("name = " + name.toUpperCase());
        /*
            //아래와 같이 쓸 수도 있음
            String name = findNameById(id).orElse("unknown");
            System.out.println("name = " + name.toUpperCase());
         */
    }

    static Optional<String> findNameById(Long id) {
        String findName = map.get(id);
//        Optional<String> optName = Optional.ofNullable(findName); //Optional 객체 생성
//        return optName;//Optional 객체 생성
        return Optional.ofNullable(findName);
    }

}
