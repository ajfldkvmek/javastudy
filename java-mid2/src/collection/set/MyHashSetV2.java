package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV2 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private LinkedList<Object>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV2(){
        initBuckets();
    }

    public MyHashSetV2(int capacity){
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(Object value){
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if(bucket.contains(value)){
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(Object searchValue){
        int hashIndex = hashIndex(searchValue);
        LinkedList<Object> bucket = buckets[hashIndex];
//        hashCode 를 오버라이드 하면 아래 과정이 진행됨
//        for (Object object : bucket) {
//            if(object.equals(searchValue)){
//                return true;
//            }
//        }
        return bucket.contains(searchValue);
    }

    public boolean remove(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
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
        return "MyHashSetV2{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
    private int hashIndex(Object value){
        //음수오면 양수 절대값 치환해서 index 계산
        return Math.abs(value.hashCode()) % capacity;
    }
}
