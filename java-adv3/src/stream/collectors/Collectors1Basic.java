package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//import static java.util.stream.Collectors.toList;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Collectors1Basic {

    /**
     *  보통 Collectors 를 사용하 때는 Collectors 를 static import 해준 뒤 사용하는 것이 권장됨
     *  ex
     *  List<String> list1 = Stream.of("Java", "Spring", "JPA")
     *                 .collect(toList());
     */
    public static void main(String[] args) {
        //기본기능
        List<String> list1 = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        //수정 불가능 리스트
        List<String> list2 = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toUnmodifiableList());
        System.out.println("list2 = " + list2);
//        list2.add("qwe"); //RuntimeException
//        toUnmodifiableList 를 사용해서 리스트를 생성하면 불변리스트로 생성된다

        /*
        List<String> list = Stream.of("Java", "Spring", "JPA").toList();
        로 리스트를 바로 생성할 수 있는데 이는 불변 리스트로 제공됨(since java16)
         */

        Set<Integer> set1 = Stream.of(1, 2, 2, 3, 3, 3)
                .collect(Collectors.toSet());
        System.out.println("set1 = " + set1);

        //타입 지정
        TreeSet<Integer> treeSet1 = Stream.of(3, 4, 5, 2, 1)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet1 = " + treeSet1);



    }

}
