package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStackMain {

    public static void main(String[] args) {
        //new ArrayLinkedList 도 가능하지만 성능은 Deque 로 사용하는 것이 더 좋다
        Deque<Integer> deque = new ArrayDeque<>();

        //데이터 추가
        deque.push(1);
        deque.push(2);
        deque.push(3);

        //다음 꺼낼 데이터 확인
        deque.peek();

        //데이터 꺼내고 확인
        System.out.println(deque.pop());

        System.out.println(deque);
    }
}
