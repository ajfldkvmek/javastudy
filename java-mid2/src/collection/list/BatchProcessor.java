package collection.list;

public class BatchProcessor {

    /**
     *  구체 클래스에 의존관계를 주입하면
     *  코드에 수정이 발생할 경우 배치파일도 수정이 필요하다
     *  
     *  따라서 의존관계를 주입할 때는 추상화를 한 뒤 의존관계를 설정하도록 하자
     */
//    private final MyArrayList<Integer> list = new MyArrayList<>();
//
//    public void logic(int size){
//        for(int i = 0; i < size; i++){
//            list.add(0, i);
//        }
//    }
//    private final MyLinkedList<Integer> list = new MyLinkedList<>();
//    public void logic(int size){
//        for(int i = 0; i < size; i++){
//            list.add(0, i);
//        }
//    }

    /**
     *  아래와 같이 인터페이스(추상화)에 의존관계를 주입한 뒤
     *  생성자를 통해 구체화하면
     *  구체클래스와는 다르게 상황에 맞게 사용할 수 있다.
     */
    private final MyList<Integer> list;

    //MyList = new ArrayList
    //MyList = new LinkedList
    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void logic(int size){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");

    }



}
