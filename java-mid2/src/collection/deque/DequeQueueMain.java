package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeQueueMain {

    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();

        //데이터 추가
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        //다음 꺼낼 데이터 확인
        queue.peek();

        //데이터 꺼내고 확인
        System.out.println(queue.poll());

        System.out.println(queue);
    }


}
