package collection.deque.test.ex1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] productArr = { {"JAVA", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < productArr.length; i++){
            String key = productArr[i][0];
            String value = productArr[i][1];
            map.put(key, value);
        }

//        System.out.println(map);

        Set<String > keySet = map.keySet();
        Iterator<String> it = keySet.iterator();

        while(it.hasNext()){
            String k = it.next();
            System.out.println("제품: " + k + ", 가격: " + map.get(k));
        }
    }

}
