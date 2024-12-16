package thread.collection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {

    public static void main(String[] args) {

        /**
         *   이렇게 하면 자바 자체에서 제공하는 프록시패턴이 적용된 컬렉션틀 사용가능
         *   List, Collection, Map, Set 등 다양한 컬렉션에 대해 적용가능
         *
         *   하지만 이 방법은 모든 메서드에 synchronized 를 적용하는 방법으로 오버헤드가 많이 발생한다.
         *
         *   그래서!!!!!!!!!!
         *
         *   자바에서는
         *
         *   concurrent 패키지에서 동시성 컬랙션(concurrent collection) 을 제공한다!
         *
         */
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        list.add("data1");
        list.add("data2");
        list.add("data3");
        list.add("data4");
        list.add("data5");

        System.out.println(list.getClass().getSimpleName());

    }

}
