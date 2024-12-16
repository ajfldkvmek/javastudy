package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> llist = new MyLinkedList<>();
       BatchProcessor batchProcessor1 =  new BatchProcessor(list);
       BatchProcessor batchProcessor2 =  new BatchProcessor(llist);

       batchProcessor2.logic(100_000);
//       batchProcessor1.logic(100_000);
    }
}
