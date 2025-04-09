package lambda.lambda4.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV3<T> {

    private List<T> internalList;

    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }

    //static 의 경우 제네릭 따로 선언해줘야함
    public static <T> MyStreamV3<T> of(List<T> internalList) {
        return new MyStreamV3(internalList);
    }

//    public static void <T> methodChain(List<T> internalList) {
//        MyStreamV3 stream = MyStreamV3.of(internalList);
//        List<T> result = stream.filter(n -> n % 2 == 0)
//                .map(n -> n * 2).toList();
//    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T i : internalList) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return MyStreamV3.of(filtered);
    }

    public <R> MyStreamV3<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T i : internalList) {
            mapped.add(mapper.apply(i));
        }
        return MyStreamV3.of(mapped);
    }

    public List<T> toList() {
        return internalList;
    }

    public void forEach(Consumer<T> consumer) {
        for (T i : internalList) {
            consumer.accept(i);
        }
    }

}
