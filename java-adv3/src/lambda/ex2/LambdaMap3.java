package lambda.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMap3 {

    @FunctionalInterface
    public interface MyFunction<T, R> {
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> list, MyFunction<T, R> myFunction) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(myFunction.apply(t));
        }
        return newList;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "java", "lambda");

        List<String> decoString = map(list, s -> "***" + s + "***");
        List<String> upperString = map(list, String::toUpperCase);


        System.out.println("decoString = " + decoString);
        System.out.println("upperString = " + upperString);

    }
}
