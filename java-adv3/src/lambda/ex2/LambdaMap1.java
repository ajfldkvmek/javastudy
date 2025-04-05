package lambda.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMap1 {

    public interface MyFunction {
        String apply(String s);
    }

    public static List<String> map(List<String> list, MyFunction myFunction) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(myFunction.apply(s));
        }
//        System.out.println("newList = " + newList);
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
