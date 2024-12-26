package generic.ex1;

public class GenericBox<T> {

    public T value;

    public void set(T value) {
        this.value = value;
    }

    public T get(){
        return value;
    }


}
