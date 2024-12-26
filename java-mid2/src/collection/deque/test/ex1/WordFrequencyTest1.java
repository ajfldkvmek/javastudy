package collection.deque.test.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordFrequencyTest1 {

    public static void main(String[] args) {

        String text = "orange banana apple apple banana apple";

        Map<String, Integer> map = new HashMap<>();

        String[] strArr = text.split(" ");

        for (String s : strArr) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        System.out.println(map);
    }
}
