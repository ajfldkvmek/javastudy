package collection.array;

import java.util.Arrays;

public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV4(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity){
        //생성자에는 제네릭 못한다! new E[initialCapacity] 안됨
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(E e){

        //리스트는 capacity 이상으로 데이터가 추가되면 크기를 동적으로 늘려주면된다.
        if(size == elementData.length){
            grow();
        }

        elementData[size] = e;
        size++;
    }

    public void add(int index, E e){
        //리스트는 capacity 이상으로 데이터가 추가되면 크기를 동적으로 늘려주면된다.
        if(size == elementData.length){
            grow();
        }
        //데이터 이동
        shiftRightForm(index);
        elementData[index] = e;
        size++;
    }

    private void shiftRightForm(int index) {
        for(int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
    }

    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftForm(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void shiftLeftForm(int index) {
        for(int i = index; i < size - 1; i++){
            elementData[i] = elementData[i+1];
        }
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity*2;

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E) elementData[index];
    }

    public E set(int index, E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(E e){
        for( int i = 0; i < size; i++ ){
            if(e.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOf(elementData, size))
                        + " size=" + size + ", capacity=" + elementData.length; //배열을 지정한 길이만큼 자름
    }
}
