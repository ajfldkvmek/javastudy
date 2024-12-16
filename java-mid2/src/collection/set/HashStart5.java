package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

    static final int CAPACITY = 10;
    //{1, 2, 5, 8, 14, 99}

    public static void main(String[] args) {

        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for(int i = 0; i < CAPACITY; i++){
            buckets[i] = new LinkedList<>();

        }

//        System.out.println("buckets: " + Arrays.toString(buckets));

        add(buckets,1);
        add(buckets,2);
        add(buckets,5);
        add(buckets,8);
        add(buckets,14);
        add(buckets,99);
        add(buckets,9);

        System.out.println("buckets: " + Arrays.toString(buckets));

        System.out.println( "9값이 있니? " + contains(buckets,9));
        System.out.println("7값이 있니? " + contains(buckets, 7));
    }


    private static  void add(LinkedList<Integer>[] buckets, int value){
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if(!bucket.contains(value)){
            //입력된 값이 이미 존재하는 값인지 확인
            bucket.add(value);
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
//        for(Integer integer : bucket){
//            if(integer == searchValue){
//                return true;
//            }
//        }
//        return false;
    }


    static int hashIndex(int value){
        return value%CAPACITY;
    }

}
