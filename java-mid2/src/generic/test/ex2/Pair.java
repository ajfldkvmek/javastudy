package generic.test.ex2;

public class Pair<T1, T2> {

    private T1 t1;
    private T2 t2;
    public void setFirst(T1 t1) {
        this.t1 = t1;
    }

    public void setSecond(T2 t2) {
        this.t2 = t2;
    }


    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }
}
