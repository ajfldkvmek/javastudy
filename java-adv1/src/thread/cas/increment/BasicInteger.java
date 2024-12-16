package thread.cas.increment;

public class BasicInteger implements IncrementInteger {

    private int value;

    @Override
    public void increment() {
        //이렇게 공유 가능 자원에 원자적이지 않은 연산을 사용하면 문제가 발생할 수 있다.
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
