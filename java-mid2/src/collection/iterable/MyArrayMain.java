package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1,2,3,4,5});

        Iterator<Integer> it = myArray.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
