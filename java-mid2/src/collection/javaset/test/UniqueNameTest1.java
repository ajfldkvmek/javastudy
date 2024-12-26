package collection.javaset.test;

import java.util.HashSet;
import java.util.Set;

public class UniqueNameTest1 {

    public static void main(String[] args) {

        Integer[] inputArr = {30, 20, 20, 10, 10};

        Set<Integer> hashSet = new HashSet<>();


        for (Integer integer : inputArr) {
            hashSet.add(integer);
        }

        System.out.println(hashSet);
    }
}
