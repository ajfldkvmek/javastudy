package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1(){
        initBuckets();
    }

    public MyHashSetV1(int capacity){
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(int value){
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if(bucket.contains(value)){
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(int searchValue){
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
//        list는 값을 지우는 방법이 두 개
//        1. index로 지우기
//        2. value로 지우기
//        아래와 같이 값으로 지우기 위해서는 파라메터를 wrapper 타입으로 바꿔서 보내야한다
//        단순히 숫자를 집어넣게 되면 기본적으로 index를 기준으로 데이터를 삭제함
        boolean result = bucket.remove(Integer.valueOf(value));
        if(result){
            size--;
            return true;
        }
        else {
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
    private int hashIndex(int value){
        return value % capacity;
    }
}
