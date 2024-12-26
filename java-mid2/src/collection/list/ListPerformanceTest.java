package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {

    public static void main(String[] args) {
        int size = 50000;
        System.out.println("==ArrayList 추가==");
        addFirst(new ArrayList<>(), size);

        System.out.println("==LinkedList 추가==");
        addFirst(new LinkedList<>(), size);



        System.out.println("==ArrayList 추가==");
        addLast(new ArrayList<>(), size);

        System.out.println("==LinkedList 추가==");
        addLast(new LinkedList<>(), size);
    }

    private static void addFirst(List<Integer> list, int size){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("0번 index에 추가::크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }


    private static void addLast(List<Integer> list, int size){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("0번 index에 추가::크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

}
