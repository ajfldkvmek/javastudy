package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer>{


    /**
     *  iterable 인터페이스는
     *  반복자(iterator)를 반환하면 된다.
     */
    private int[] numbers;
    public MyArray(int[] numbers){
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }
}
