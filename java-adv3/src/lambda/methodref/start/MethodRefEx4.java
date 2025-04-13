package lambda.methodref.start;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {

    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Kim"),
                new Person("Lee"),
                new Person("Park")
        );

        List<String> result1 = mapPersonToString(personList, (p) -> p.introduce());
        System.out.println("strings = " + result1);


        List<String> result2 = mapPersonToString(personList, Person::introduce);
        System.out.println("strings = " + result2);

        List<String> result3 = mapStringToString(result1, (String s) -> s.toUpperCase());
        System.out.println("result3 = " + result3);

        List<String> result4 = mapStringToString(result2, String::toUpperCase);
        System.out.println("result4 = " + result4);
    }

    static List<String> mapPersonToString(List<Person> personList, Function<Person, String> function) {
        List<String> result = new ArrayList<>();
        for (Person person : personList) {
            String apply = function.apply(person);
            result.add(apply);
        }
        return result;
    }


    static List<String> mapStringToString(List<String> strings, Function<String, String> function) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            String apply = function.apply(s);
            result.add(apply);
        }
        return result;
    }


}

