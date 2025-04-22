package functional;

import java.util.Arrays;
import java.util.List;

public class ImmutableMain2 {

    public static void main(String[] args) {

        // mutable
        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = new MutablePerson("Lee", 10);

        List<MutablePerson> originList = List.of(m1, m2);
        System.out.println("originList = " + originList);
        List<MutablePerson> resultList = originList.stream()
                .map(p -> {
                    p.setAge(p.getAge() + 1);
                    return p;
                }).toList();

        // 아래와 같은 경우
        // 원본데이터도 변경이 발생해서 기존의 데이터를 알 수 없게되는 상황이 발생함
        System.out.println("============ 실행후 =============");
        System.out.println("originList = " + originList);
        System.out.println("resultList = " + resultList);

    }

}
