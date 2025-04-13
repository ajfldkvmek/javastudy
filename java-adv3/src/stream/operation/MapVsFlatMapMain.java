package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMapMain {
    
    public static void main(String[] args) {

        List<List<Integer>> lists = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        System.out.println("lists = " + lists);

        // for
        ArrayList<Integer> forResult = new ArrayList<>();
        for(List<Integer> list : lists) {
            for(Integer i : list) {
                forResult.add(i);
            }
        }
        System.out.println("forResult = " + forResult);

        // map
        List<Stream<Integer>> list1 = lists.stream()
                .map(list -> list.stream())
                .toList();

        System.out.println("list1 = " + list1);

        // flatMap
        List<Integer> list2 = lists.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("list2 = " + list2);
    }
}
