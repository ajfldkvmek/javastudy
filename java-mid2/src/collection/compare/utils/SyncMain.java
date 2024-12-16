package collection.compare.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {

    /**
     *  Collections.synchronizedList(list) 를 사용하게되면
     *  멀티스레드 상황에서 동기화 문제가 발생하지 않는 안전한 리스트로 만들 수 있다.
     *  (하지만 동기화 작업으로 인하여 일반 리스트보다 성능은 느림)
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list class = " + list.getClass());
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println("synchronizedList class = " + synchronizedList.getClass());
    }
}
