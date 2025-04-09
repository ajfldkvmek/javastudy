package lambda.lambda4.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV2 {

    private List<Integer> integerList;

    private MyStreamV2(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public static MyStreamV2 of(List<Integer> integerList) {
        return new MyStreamV2(integerList);
    }

    public static void methodChain(List<Integer> integerList) {
        MyStreamV2 stream = MyStreamV2.of(integerList);
        List<Integer> result = stream.filter(n -> n % 2 == 0)
                .map(n -> n * 2).toList();
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : integerList) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : integerList) {
            mapped.add(mapper.apply(i));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList() {
        return integerList;
    }

}
