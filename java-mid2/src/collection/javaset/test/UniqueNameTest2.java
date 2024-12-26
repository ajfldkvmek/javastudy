package collection.javaset.test;

import java.util.*;

public class UniqueNameTest2 {

    public static void main(String[] args) {

//        Integer[] inputArr = {30, 20, 20, 10, 10};
//        List<Integer> list =  List.of(30, 20, 20, 10, 10);
        Set<Integer> set = new TreeSet<>( List.of(30, 20, 20, 10, 10));
        for (Integer s : set) {
            System.out.println(s);
        }

//        Set<Integer> set = new LinkedHashSet<>();
//        간편한 list 생성 java9 이상부터는 list.of 사용권장
//        List<Integer> list =  Arrays.asList(1, 2, 3);
//        List<Integer> list =  List.of(1, 2, 3);

//        System.out.println(set);
    }
}
