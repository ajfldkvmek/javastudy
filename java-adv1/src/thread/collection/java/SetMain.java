package thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        //순서보장 x
        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);

        System.out.println("copySet::" + copySet);

        // comparator 를 통해 정렬된 상태로 저장됨
        ConcurrentSkipListSet<Object> skipSet = new ConcurrentSkipListSet<>();
        skipSet.add(3);
        skipSet.add(1);
        skipSet.add(2);
        System.out.println("skipSet::" + skipSet);

    }
}
