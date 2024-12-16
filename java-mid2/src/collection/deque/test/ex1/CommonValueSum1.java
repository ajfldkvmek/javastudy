package collection.deque.test.ex1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommonValueSum1 {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);

        Map<String, Integer> sumMap = new HashMap<>();

        Set<String> keySet = map1.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println("key::" + key);
            if(map2.containsKey(key)){
                sumMap.put(key, map1.get(key)+map2.get(key));
            }
        }

        System.out.println(sumMap);
    }
}
