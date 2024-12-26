package thread.collection.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapMain {

    /**
     *
     * @param args
     *
     *  실무에서는 synchronized 는 웬만하면 사용을 지양하고
     *  아래와 같은 방법을 사용하는 것이 권장됨
     */
    public static void main(String[] args) {
        Map<Integer, String> map1 = new ConcurrentHashMap<>();
        map1.put(1, "data1");
        map1.put(3, "data3");
        map1.put(2, "data2");
        System.out.println(map1);


        Map<Integer, String> map2 = new ConcurrentSkipListMap<>();
        map2.put(1, "data1");
        map2.put(3, "data3");
        map2.put(2, "data2");
        System.out.println(map2);
    }
}
