package collection.deque;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        //자바의 컬렉션중 Stack와 Queue는 더이상 사용을 권장하지 않는다
        //레거시 코드들과의 호환성을 위해서만 존재하기 때문에
        //새로 작성하는 경우에는 Deque를 사용하도록하자.

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);
        
        //다음 꺼낼 데이터 확인(꺼내지 않고 확인만)
        queue.peek();

        //꺼내서확인
        queue.poll();

        System.out.println(queue);
    }
}
