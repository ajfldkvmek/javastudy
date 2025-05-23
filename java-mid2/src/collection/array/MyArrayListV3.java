package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV3(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e){

        //리스트는 capacity 이상으로 데이터가 추가되면 크기를 동적으로 늘려주면된다.
        if(size == elementData.length){
            grow();
        }

        elementData[size] = e;
        size++;
    }

    public void add(int index, Object e){
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

    public Object remove(int index) {
        Object oldValue = get(index);
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

    public Object get(int index){
        return elementData[index];
    }

    public Object set(int index, Object object){
        Object oldValue = elementData[index];
        elementData[index] = object;
        return oldValue;
    }

    public int indexOf(Object e){
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
