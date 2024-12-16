package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV3<E> implements MySet<E> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private LinkedList<E>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV3(){
        initBuckets();
    }

    public MyHashSetV3(int capacity){
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(E value){
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        if(bucket.contains(value)){
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(E searchValue){
        int hashIndex = hashIndex(searchValue);
        LinkedList<E> bucket = buckets[hashIndex];
//        hashCode 를 오버라이드 하면 아래 과정이 진행됨
//        for (Object object : bucket) {
//            if(object.equals(searchValue)){
//                return true;
//            }
//        }
        return bucket.contains(searchValue);
    }

    public boolean remove(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
//        list는 값을 지우는 방법이 두 개
//        1. index로 지우기
//        2. value로 지우기
//        아래와 같이 값으로 지우기 위해서는 파라메터를 wrapper 타입으로 바꿔서 보내야한다
//        단순히 숫자를 집어넣게 되면 기본적으로 index를 기준으로 데이터를 삭제함
        boolean result = bucket.remove(value);
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
        return "MyHashSetV3{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
    private int hashIndex(E value){
        //음수오면 양수 절대값 치환해서 index 계산
        return Math.abs(value.hashCode()) % capacity;
    }
}
