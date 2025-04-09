package lambda.lambda4.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyStreamV1 {

    private List<Integer> integerList;

    public MyStreamV1(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : integerList) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return new MyStreamV1(filtered);
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer i : integerList) {
            mapped.add(mapper.apply(i));
        }
        return new MyStreamV1(mapped);
    }

    public List<Integer> toList() {
        return integerList;
    }

}
