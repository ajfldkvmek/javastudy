package lambda.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaMap {

    public static List<String> map(List<String> list, UnaryOperator<String> operator) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(operator.apply(s));
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
