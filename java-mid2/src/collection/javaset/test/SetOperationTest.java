package collection.javaset.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationTest {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3,4,5,6,7));

        intersection(set1, set2);
        union(set1, set2);
        difference(set1, set2);
    }

    private static void intersection(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> set = new HashSet<>();
        for (Integer i : s1) {
            if(s2.contains(i)){
                set.add(i);
            }
        }
        System.out.println(set);
    }
    private static void union(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> set = new HashSet<>();
        set.addAll(s1);
        set.addAll(s2);
//        for (Integer i : s1) {
//            set.add(i);
//        }
//        for (Integer i : s2) {
//            set.add(i);
//        }
        System.out.println(set);
    }

    private static void difference(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> set = new HashSet<>();
//        for (Integer i : s1) {
//            set.add(i);
//        }
//        for (Integer i : s2) {
//            if(s2.contains(i)){
//                set.remove(i);
//            }
//        }
        set.addAll(s1);
        set.removeAll(s2);
        System.out.println(set);
    }

}
